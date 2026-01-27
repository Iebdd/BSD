exec 2> error.err

if [ $# -ne 2 ] 
then
	exit 42
fi

if [ $1 != "-r" ] 
then
	exit 41
fi

if [ -d $2 ]
then
	echo "Deleting directory $2"
else
	echo "Deleting filr $2"
fi

rm $2