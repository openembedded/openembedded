#/bin/sh

model="`cat /proc/cpuinfo | sed -n "/Hardware/s/.*\:\ \(.*\)/\1/p"`"

case $model in
*Collie)	par="-height 240";;
*00)		par="-height 240";;
*)		par="";;
esac

echo "Model: [$model]"
echo "Launching prboom $par $*"

prboom $par $*
