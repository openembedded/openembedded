#/bin/sh

model="`cat /proc/cpuinfo | sed -n "/Hardware/s/.*\:\ \(.*\)/\1/p"`"

if ! test -d "$HOME/.prboom"
then
	case $model in
	*Collie)	par="-height 240";;
	*)		par="";;
	esac
fi

echo "Model: [$model]"
echo "Launching prboom $par $*"

prboom $par $*
