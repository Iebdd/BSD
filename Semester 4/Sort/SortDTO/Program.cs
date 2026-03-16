using System.Runtime.InteropServices;
using System.Text;

namespace SortDTO;

class Program
{
    static void Main(string[] args)
    {
        if (args.Length != 1)
        {
            Console.WriteLine(RuntimeInformation.IsOSPlatform(OSPlatform.Windows)
                ? "Usage: SortDTO.exe <path>"
                : "Usage: ./SortDTO <path>");
            Environment.Exit(1);
        }
        var DTOs = EnumerateObjects(args[0]).ToList();
        var longest = DTOs.Aggregate((i1,i2) => i1.Length > i2.Length ? i1 : i2).Length;
        var prompt = $"Select which piece should be sorted (1 - {longest}):";
        Console.WriteLine(prompt);
        int userChoice;
        while (!int.TryParse(Console.ReadLine(), out userChoice) && (userChoice < 1 || userChoice > longest))
        {
            Console.WriteLine($"Invalid choice {Environment.NewLine}{prompt}");
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