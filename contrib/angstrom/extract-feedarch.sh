#!/bin/sh

if [ ! -d archs ] ; then
	mkdir archs
fi

for feedconfig in $(find . -name "angstrom-feed-configs_*") ; do
	rm -rf feedtemp ; mkdir feedtemp
	dpkg-deb -X $feedconfig feedtemp >& /dev/null
	echo $(tail -n1 feedtemp/etc/opkg/arch.conf | awk '{print $2}') >> archs/$(tail -n2 feedtemp/etc/opkg/arch.conf | head -n1 | awk '{print $2}')
	rm -rf feedtemp
done

# Fixups
cat archs/iwmmxt >> archs/armv5te || true
cat archs/omap3517-evm >> archs/armv7a || true
rm -f archs/arm archs/iwmmxt archs/omap3517-evm
touch archs/iwmmxt archs/sparc
touch archs/sparc

#    "mipsel")
#            machines="";;

cat /tmp/sort-head.sh
for arch in archs/* ; do
	echo -e "\t\"$(basename $arch)\")"
	cat $arch | sort | awk '{print $1}' | uniq | xargs echo -ne '\t\t\tmachines="' | sed -e 's:machines=" :machines=":g'
	echo '" ;;'
	cat $arch | sort | awk '{print $1}' | uniq > /tmp/feedsort && mv /tmp/feedsort $arch
done
cat /tmp/sort-footer.sh

