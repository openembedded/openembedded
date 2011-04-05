#!/bin/bash

# Angstrom feed sorting script
# This must be run in unsorted/ directory 

ipkg_tools_path="/home/angstrom/bin"

if [ $(basename $PWD) != "unsorted" ] ; then
	echo "Not in feed dir! Exiting"
	exit 1
fi	

if [ $(find . -name "*.ipk" | wc -l) -gt 0 ] ; then
	echo "Unsorted packages found"
else
	echo "No unsorted packages found. Exiting"
	exit 1
fi

rm Packages* >& /dev/null

# Find ipkg files in unsorted/ and remove stale ones
echo "Deleting morgue directories "
find . -name morgue | xargs rm -rf 
echo "Moving packages to the top level directory"
find */ -name  "*.ipk" -exec mv  '{}'  ./ \;

# Make a list of ipkg files already present in feeds and in unsorted
echo "Making a list of unsorted packages"
for i in $(find . -name "*.ipk") ; do basename $i ; done > files-unsorted
# Make a list of duplicates and delete those
echo "Finding duplicate packages in unsorted"
cat files-sorted files-unsorted | sort | uniq -d > files-duplicate
echo "Removing duplicate packages in unsorted"
cat files-duplicate | xargs rm -f

for i in $(find . -name "*.ipk") ; do basename $i ; done > files-sorted-new

# Log remaining packages to a file 
find . -name "*.ipk" |grep -v dbg | grep -v -- -dev | grep -v -- -doc | grep -v -- -static | grep -v angstrom-version | grep -v locale > new-files.txt
for newfile in $(cat new-files.txt | sed s:./::g) ; do
    echo "$(date -u +%s) $newfile $(basename ${PWD})" >> ../upload-full.txt
done    
tail -n 100 ../upload-full.txt > ../upload.txt

do_sort() {
archdir=$arch

case "$arch" in
	"486sx")
			machines="vortex86sx" ;;
	"armv4")
			machines="collie h3600 h3800 htcwallaby jornada56x jornada7xx shark simpad" ;;
	"armv4t")
			machines="acern30 amsdelta at2440evb cs-e9302 ep93xx eteng500 eten-m800 fic-gta01 fic-gta02 gesbc-9302 h1940 h6300 kb9202 ks8695 m8050 micro2440 mini2440 om-gta01 om-gta02 rx1950 rx3000 sarge-at91 simone smdk2440 smdk2443 topas910 ts72xx" ;;
	"armv5te")
			machines="a1200 a780 a910 afeb9260 afeb9260-180 akita am180x-evm
 asus620 asus730 at91cap9adk at91-l9260 at91sam9260ek at91sam9261ek
 at91sam9263ek at91sam9g10ek at91sam9g20ek at91sam9g45ek at91sam9g45ekes
 at91sam9rlek aximx50 aximx50v bd-neon c7x0 chumby chumby-falconwing cm-x270
 cm-x300 da830-omapl137-evm da850-omapl138-evm davinci-dvevm davinci-sffsdr
 devkitidp-pxa255 dm355-evm dm355-leopard dm357-evm dm365-evm dm368-evm
 dm6446-evm dm6467-evm dm6467t-evm dns323 dockstar e680 ea3250 em-x270 er0100
 eseries ghi270 gumstix gumstix-connex gumstix-custom-connex
 gumstix-custom-verdex gumstix-verdex h1910 h2200 h3900 h4000 h5000 hawkboard
 hipox htcalpine htcapache htcblueangel htchimalaya htcsable htctornado
 htcuniversal hx2000 hx4700 imote2 ixp4xxle kixrp435 kuropro logicpd-pxa270
 looxc550 lspro magician mainstone mh355 mp900c mtx-3 mtx-3a mv2120 mx21ads
 mx27ads n2100 navman-icn330 netbook-pro neuros-osd neuros-osd2 nhk15 nokia770
 nslu2le omap1510inn omap1610h2 omap1710h3 omap5912osk openrd-base openrd-client
 palmld palmt650 palmt680 palmtc palmtt palmtt3 palmtt5 palmtx palmz31
 palmz71 palmz72 poodle qemuarm rokre2 rokr-e2 rokre6 ronetix-pm9261
 ronetix-pm9263 sgh-i900 sheevaplug spitz stamp9g20evb topas910 tosa
 triton ts409 tsx09 tx25 tx27" ;;
	"armv5teb")
			machines="fsg3be ixp4xxbe nslu2be" ;;
	"armv6")
			machines="bug iphone mx31ads mx31moboard mini6410 nokia800 omap2420h4 omap2430sdp pcm043 smartq5 smartqv7 smdk6410" ;;
	"armv6-novfp")
			machines="htcblackstone htcdiamond htcdream htckaiser htcnike htcpolaris htcraphael htctitan htcvogue" ;;
	"armv7a")
			machines="am3517-evm am3517-crane am45x-evm archos5 archos5it beagleboard bug20 cm-t35 dm37x-evm am37x-evm am387x-evm am389x-evm babbage c6a814x-evm c6a816x-evm dm814x-evm efikamx htcleo igep0020 nokia900 omap3517-evm omap3evm omap3-pandora omap3-touchbook omap4430-sdp omapzoom omapzoom2 omapzoom36x overo palmpre omap4430-panda usrp-embedded usrp-e1xx" ;;
	"armv7a-vfp")
			machines="ac100" ;;
	"avr32")
			machines="at32stk1000 atngw100" ;;
	"bfin")
			archdir="blackfin"
			machines="adsp-bf537-stamp" ;;
	"geode")
			machines="alix geodegx geodelx iei-nanogx-466 xo" ;;
	"i486")
			machines="wrap" ;;
	"i586")
			machines="d201gly2 epia i586-generic netvisa progear x86 x86-uml" ;;
	"i686")
			machines="eee701 i686-generic qemux86 guinness progear ion qemux86 vmware x86-32-nocona x86-prescott" ;;
	"iwmmxt")
			machines="" ;;
	"mips")
			machines="qemumips" ;;
	"mipsel")
			machines="ben-nanonote db1200 lsmipsel mtx-1 mtx-2 qemumipsel rb500 stb225 wgt634u wl500g wrt54" ;;
	"powerpc")
			machines="gamecube p2020ds" ;;
	"ppc405")
			machines="dht-walnut kilauea magicbox xilinx-ml403 xilinx-ml410" ;;
	"ppc440e")
			machines="canyonlands sequoia xilinx-ml507" ;;
	"ppc603e")
			machines="efika lite5200 lsppchd lsppchg n1200 qemuppc storcenter" ;;
	"ppce300c2")
			machines="mpc8323e-rdb" ;;
	"ppce300c3")
			machines="boc01 mpc8313e-rdb mpc8315e-rdb" ;;
	"ppce500")
			machines="tqm8540" ;;
	"ppce500v2")
			machines="calamari" ;;
	"ppce600")
			machines="mpc8641-hpcn" ;;
	"sh4")
			machines="qemush4 titan" ;;
	"sparc")
			machines="sun4cdm" ;;
	"x86")
			machines="colinux" ;;
esac

if [ $(find . -name  "*_$arch.ipk"| wc -l) -gt 0 ] ; then
	export SORTFEED=1
else
	export SORTFEED=0
fi

echo "Sorting $arch"

mkdir -p ../$archdir/base/ || true
for i in `find . -name  "*_$arch.ipk"` ; do mv $i ../$archdir/base/ ; done
        for machine in $machines ; do
                for i in `find . -name  "*_$machine.ipk"| grep $machine` ; do mkdir -p ../$archdir/machine/$machine || true ;mv $i ../$archdir/machine/$machine ; done
	done
( cd ../$archdir && do_index )
}

do_index() {
echo "Processing $(basename $PWD) packages...."

BPWD=`pwd`

if [ "${SORTFEED}" -eq 1 ] ; then
mkdir -p base
cd base

mkdir -p ../debug ../perl ../python ../gstreamer ../locales/en || true

#split the feeds based on names
mv python* ../python/ >& /dev/null
mv perl* ../perl/ >& /dev/null
mv *-dbg* ../debug/ >& /dev/null
mv gst* ../gstreamer >& /dev/null

for i in ../* ; do
  if [ -d $i ]; then
      cd $i
      echo -n "building index for $i:" |sed s:\.\./::
      ${ipkg_tools_path}/opkg-make-index -m -p Packages -l Packages.filelist  -L ../locales  . >& /tmp/index-log
      echo " DONE"
  fi
done

mkdir -p ${BPWD}/locales/en/
cd ${BPWD}/locales/en/
echo -n "building index for locales:"
for i in ../* ; do
  if [ -d $i ]; then
   echo -n " $i" |sed s:\.\./::
   ${ipkg_tools_path}/opkg-make-index -m -p Packages -l Packages.filelist . >& /dev/null;
   cd $i
  fi
 done
echo " DONE"

fi
mkdir -p  ${BPWD}/machine
cd ${BPWD}/machine

for i in ./* ; do
  if [ -d $i ]; then
     cd $i
     echo -n "building index for machine $i:"
     ${ipkg_tools_path}/opkg-make-index -m -p Packages -l Packages.filelist . >& /dev/null
     echo " DONE"
     cd ../
  fi
done
cd ${BPWD} 

}

echo "Processing 'all' feed"
for i in `find . -name  "*.ipk"| grep _all` ; do mkdir -p ../all/ || true ;mv $i ../all/ ; done
 (mkdir -p ../all ; cd ../all && ${ipkg_tools_path}/opkg-make-index -p Packages -m . >& /dev/null ; touch Packages.sig )

mkdir -p ../sdk ; mv *sdk.ipk ../sdk/ || true
 (mkdir -p ../sdk ; cd ../sdk && ${ipkg_tools_path}/opkg-make-index -p Packages -m . >& /dev/null ; touch Packages.sig )

for arch in 486sx armv4t armv4 armv5teb armv5te armv6-novfp armv6 armv7a-vfp armv7a avr32 bfin geode i486 i586 i686 iwmmxt mips mipsel powerpc ppc405 ppc440e ppc603e ppce300c2 ppce300c3 ppce500v2 ppce500 ppce600 sh4 sparc x86_64 x86; do
	do_sort
done

if [ "$1" != "--skip-sorted-list" ]; then
    echo "Updating list of sorted packages"
	cat files-sorted files-sorted-new | sort | uniq > files-sorted-tmp
	mv files-sorted-tmp files-sorted
	rm files-sorted-*
fi

if [ "$1" != "--skip-repo-update" ]; then
	( cd ~/website/repo-updater ; rm -f feeds.db* ; php update.php ; rm ../repo/feeds.db* ; cp feeds.db* ../repo )
fi

echo -n "Stripping source lines from Package files"
for i in `find .. -name Packages` ; do grep -v ^Source: $i|gzip -c9>$i.gz ;gunzip -c $i.gz>$i ; touch $i.sig ; done
echo " DONE"


