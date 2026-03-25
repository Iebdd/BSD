using System.Runtime.InteropServices;
using System.Text;

namespace SortDTO;

class Program
{
    static void Main(string[] args)
    {
        var order = new Dictionary<char, int>
        {
            {'a',  0}, {'b',  1}, {'c',  2}, {'d',  3}, {'e',  4}, {'f',  5}, {'g',  6}, {'h',  7}, {'i',  8}, 
            {'j',  9}, {'k', 10}, {'l', 11}, {'m', 12}, {'n', 13}, {'o', 14}, {'p', 15}, {'q', 16}, {'r', 17}, 
            {'s', 18}, {'t', 19}, {'u', 20}, {'v', 21}, {'w', 22}, {'x', 23}, {'y', 24}, {'z', 25}, {'A', 26},
            {'B', 27}, {'C', 28}, {'D', 29}, {'E', 30}, {'F', 31}, {'G', 32}, {'H', 33}, {'I', 34}, {'J', 35},
            {'K', 36}, {'L', 37}, {'M', 38}, {'N', 39}, {'O', 40}, {'P', 41}, {'Q', 42}, {'R', 43}, {'S', 44},
            {'T', 45}, {'U', 46}, {'V', 47}, {'W', 48}, {'X', 49}, {'Y', 50}, {'Z', 51}, {'1', 52}, {'2', 53}, 
            {'3', 54}, {'4', 55}, {'5', 56}, {'6', 57}, {'7', 58}, {'8', 59}, {'9', 60}, {'0', 61}
        };
        if (args.Length != 1)
        {
            Console.WriteLine(RuntimeInformation.IsOSPlatform(OSPlatform.Windows)
                ? "Usage: SortDTO <path to text file>"
                : "Usage: ./SortDTO <path to text file>");
            Environment.Exit(1);
        }

        var dtos = new List<string[]>();
        try
        {
            dtos = EnumerateObjects(args[0]).ToList();
        }
        catch (IOException e)
        {
            Console.WriteLine($"File \"{args[0]}\" could not be found");
            Environment.Exit(1);
        }
        var shortest = dtos.Aggregate((i1,i2) => i1.Length < i2.Length ? i1 : i2).Length;
        var prompt = $"Select which part elements should be sorted by (1 - {shortest}):";
        Console.Write($"{prompt}{Environment.NewLine}");
        int userChoice;
        while (!int.TryParse(Console.ReadLine(), out userChoice) || userChoice < 1 || userChoice > shortest)
        {
            Console.WriteLine($"Invalid choice {Environment.NewLine}{prompt}");
        }

        var dtoDict = new Dictionary<string, string[]>();
        try
        {
            dtoDict = dtos.ToDictionary(t => t[userChoice - 1]);
        }
        catch (ArgumentException)
        {
            Console.WriteLine("Duplicate elements are not permitted");
            Environment.Exit(1);
        }

        var sorted = dtoDict.Keys.OrderBy(x => x);
        var sortedList = sorted.Select(sortedKey => dtoDict[sortedKey]).ToList();
        using var sw = new StreamWriter($"{Path.GetDirectoryName(args[0])}{Path.DirectorySeparatorChar}{Path.GetFileNameWithoutExtension(args[0])}_sorted.txt");
        foreach (var item in sortedList)
        {
            sw.WriteLine(string.Join(" ", item));
        }
    }

    private static IEnumerable<string[]> EnumerateObjects(string path)
    {
        const int bufferSize = 128;
        using var fileStream = File.OpenRead(path);
        using var streamReader = new StreamReader(fileStream, Encoding.UTF8, true, bufferSize);
        while (streamReader.ReadLine() is { } line)
        {
            yield return line.Split(" ");
        }
    }
}