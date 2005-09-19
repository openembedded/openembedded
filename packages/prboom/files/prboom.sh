#/bin/sh

model="`cat /proc/cpuinfo | sed -n "/Hardware/s/.*\:\ \(.*\)/\1/p"`"

case $model in
*Collie)	par="-height 240";;
*Poodle)	par="-height 240";;
*00)		par="-height 240";;
*)		par="";;
esac

test -e /usr/share/games/doom/prboom.cfg && par="$par -config /usr/share/games/doom/prboom.cfg"

echo "Model: [$model]"
echo "Launching prboom $par $*"

prboom $par $*
