#!/bin/bash
FEED_BASEDIR=`pwd`

mkdir -p base x11 opie locale perl python

cd world

#moving armv5te files out of the way
#rm *armv5te* -f

#regenerate Package index
echo "regenerating world index"
rm Packages* -f ; ipkg-make-index -p Packages -l Packages.filelist -L ../locale -v . ;  mv Packages Packages.old ; rm Packages.gz -f ; grep -v Source Packages.old > Packages ; gzip -c9 Packages >Packages.gz ; rm Packages.old -f

cd $FEED_BASEDIR

#produce a splitscript
echo "making a splitscript"
python ipkg-split-feeds-koen-subfeeds world/Packages base/ x11/ opie/ > dump

echo "moving machine files out of the way"
for machine in collie c7x0 akita borzoi tosa poodle spitz ; 
do
	mkdir -p machine/$machine
	mv world/*_$machine.ipk machine/$machine/
done

echo "executing split script"
cat dump | sed -e '1d' | sh

mv base/dev/*	    base/
mv base/doc/*	    base/

mv base/perl*		perl/
mv base/locale/*/perl* perl/
mv base/python*		python/

mv opie/dev/*	    opie/
mv opie/doc/*	    opie/

mv x11/dev/*	    x11/
mv x11/doc/*	    x11/

rm -rf base/doc base/dev base/locale
rm -rf opie/doc opie/dev
rm -rf x11/doc  x11/dev


#regenerate indices for the rest of the feeds
echo "rebuilding final indices"
for feed in base x11 opie perl python ; 
do
	cd $feed ;
	rm Packages* -f ;
	ipkg-make-index -p Packages -l Packages.filelist -L ../locale -m . ;  mv Packages Packages.old ; rm Packages.gz -f ; grep -v Source Packages.old > Packages ; gzip -c9 Packages >Packages.gz ; rm Packages.old -f
	cd $FEED_BASEDIR
done

cd $FEED_BASEDIR

cd machine
for feed in * ; 
do
    cd $feed ;
    rm Packages* -f ;
	ipkg-make-index -p Packages -l Packages.filelist -L ../locale -m . ;  mv Packages Packages.old ; rm Packages.gz -f ; grep -v Source Packages.old > Packages ; gzip -c9 Packages >Packages.gz ; rm Packages.old -f
    cd ..
done

cd $FEED_BASEDIR

cd locale
for feed in * ; 
do
    cd $feed ;
    rm Packages* -f ;
	ipkg-make-index -p Packages -l Packages.filelist -m . ;  mv Packages Packages.old ; rm Packages.gz -f ; grep -v Source Packages.old > Packages ; gzip -c9 Packages >Packages.gz ; rm Packages.old -f
    cd ..
done

cd $FEED_BASEDIR
