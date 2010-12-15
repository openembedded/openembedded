#!/bin/bash

if ! [ -d libqpe ] ; then
    echo "Please execute at the recipes subdir of the OE source tree"
    exit 1
fi

if [ x$1 == x ] ; then
    echo "usage: $0 new_version"
    exit 1
fi

FILES="libqpe libqtaux libopie* libmailwrapper nonworking/opie* opie*"

NEW_VER="$1"

for i in $FILES ; do
	for j in $i/*_cvs.bb ; do
		if [ -f $j ] ; then
			NEW_FILE=`echo $j | sed "s/_cvs/_$NEW_VER/"`
			cp $j $NEW_FILE
			sed 's/\${OPIE_GIT};protocol=git;subpath=/@@@/g;ta;b;:a;s/\//_/g;s/ *\"$/.tar.bz2\"/;s/ *\\$/.tar.bz2 \\/;s/@@@/http:\/\/sources.openembedded.org\/opie-VERSION-split_/' -i $NEW_FILE
			sed "s/opie-VERSION-split/opie-$NEW_VER-split/g" -i $NEW_FILE
			sed '/^PV =/d' -i $NEW_FILE
			sed '/^OPIE_GIT_PV/d' -i $NEW_FILE
			sed 's/^PR = "r.*/PR = "r0"/' -i $NEW_FILE
			sed 's/^PR = "\${INC_PR}\..*/PR = "\${INC_PR}.0"/' -i $NEW_FILE
			cat -s $NEW_FILE > $NEW_FILE.new
			mv $NEW_FILE.new $NEW_FILE
			git add $NEW_FILE
		fi
	done
done

cp opie-icon-reload/opie-icon-reload_1.2.5.bb opie-icon-reload/opie-icon-reload_$NEW_VER.bb
git add opie-icon-reload/opie-icon-reload_$NEW_VER.bb
