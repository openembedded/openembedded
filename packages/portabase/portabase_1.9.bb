DESCRIPTION = "Portabase is a small database program for creating, browsing, \
and editing custom tables of data."
SECTION = "opie/applications"
LICENSE = "GPL"
HOMEPAGE = "http://portabase.sourceforge.net/"
DEPENDS = "metakit beecrypt"
APPNAME = "portabase"
PR = "r4"

SRC_URI = "${SOURCEFORGE_MIRROR}/portabase/portabase_${PV}.tar.gz \
	   file://qtopia.patch;patch=1 		\
	   file://fileselector.patch;patch=1    \
           file://qtversion.patch;patch=1 \
           file://qt2310-fontbug.patch;patch=1"

S = "${WORKDIR}/portabase"

inherit palmtop 

do_configure_prepend() {
	find . -name "Makefile"|xargs rm -f
}

QMAKE_PROFILES = "portabase.pro"
QPEDIR = ${OPIEDIR}
EXTRA_QMAKEVARS_POST += "CONFIG-=desktop"

# lrelease portabase.pro

do_install() {
	install -d ${D}${palmtopdir}/bin \
			${D}${palmtopdir}/apps/Applications \
			${D}${palmtopdir}/pics/${APPNAME}		\
			${D}${palmtopdir}/help/en
	install -D -m 0755 ${APPNAME} ${D}${palmtopdir}/bin/${APPNAME}
	install -m 0644 package/${APPNAME}.desktop ${D}${palmtopdir}/apps/Applications/${APPNAME}.desktop
	 
	install -D -m 0644 pics/PortaBase.png ${D}${palmtopdir}/pics/PortaBase.png
	for f in calculator.png checked.png image.png note.png save.png save_disabled.png unchecked.png calendar.xpm QtaDatePickerNext.xpm QtaDatePickerPrev.xpm
	do
		install -D -m 0644 pics/$f ${D}${palmtopdir}/pics/${APPNAME}/$f
	done         

	install -D -m 0644 help/html/${APPNAME}.html ${D}${palmtopdir}/help/en/html/${APPNAME}.html
} 


pkg_postinst() {
#!/bin/sh

NEWTYPE=application/portabase
EXT=pob

T=${NEWTYPE%/*}
S=${NEWTYPE#*/}

grep  $EXT $QPEDIR/etc/mime.types |
(
    read TYPE EXTS
    if [ -z "$TYPE" ]
    then
        if grep -q "^$NEWTYPE[  ]" $QPEDIR/etc/mime.types || grep -q "^$NEWTYPE$" $QPEDIR/etc/mime.types
        then
            if sed -e '/^'$T"\\/"$S'[   ]/ s/$/ '$EXT'/' <$QPEDIR/etc/mime.types >$QPEDIR/etc/mime.types.new ||
               sed -e '/^'$T"\\/"$S'$/ s/$/             '$EXT'/' <$QPEDIR/etc/mime.types >$QPEDIR/etc/mime.types.new
            then
                mv $QPEDIR/etc/mime.types.new $QPEDIR/etc/mime.types
                exit 0
            else
                echo >&2 "Internal MIME type update error"
                exit 1
            fi
        else
            echo "" >>$QPEDIR/etc/mime.types
            sed -e :a -e '/^\n*$/{$d;N;};/\n$/ba' $QPEDIR/etc/mime.types >$QPEDIR/etc/mime.types.new
            mv $QPEDIR/etc/mime.types.new $QPEDIR/etc/mime.types
            echo "$NEWTYPE              $EXT" >>$QPEDIR/etc/mime.types
            exit 0
        fi
    elif [ "$TYPE" = "$NEWTYPE" ]
    then
        #echo "Already done"
        exit 0
    else
        echo >&2 "$EXT already assigned to $TYPE"
        exit 1
    fi
)

NEWTYPE=text/x-csv
EXT=csv

T=${NEWTYPE%/*}
S=${NEWTYPE#*/}

grep  $EXT $QPEDIR/etc/mime.types |
(
    read TYPE EXTS
    if [ -z "$TYPE" ]
    then
        if grep -q "^$NEWTYPE[  ]" $QPEDIR/etc/mime.types || grep -q "^$NEWTYPE$" $QPEDIR/etc/mime.types
        then
            if sed -e '/^'$T"\\/"$S'[   ]/ s/$/ '$EXT'/' <$QPEDIR/etc/mime.types >$QPEDIR/etc/mime.types.new ||
               sed -e '/^'$T"\\/"$S'$/ s/$/             '$EXT'/' <$QPEDIR/etc/mime.types >$QPEDIR/etc/mime.types.new
            then
                mv $QPEDIR/etc/mime.types.new $QPEDIR/etc/mime.types
                exit 0
            else
                echo >&2 "Internal MIME type update error"
                exit 1
            fi
        else
            echo "" >>$QPEDIR/etc/mime.types
            sed -e :a -e '/^\n*$/{$d;N;};/\n$/ba' $QPEDIR/etc/mime.types >$QPEDIR/etc/mime.types.new
            mv $QPEDIR/etc/mime.types.new $QPEDIR/etc/mime.types
            echo "$NEWTYPE              $EXT" >>$QPEDIR/etc/mime.types
            exit 0
        fi
    elif [ "$TYPE" = "$NEWTYPE" ]
    then
        #echo "Already done"
        exit 0
    else
        echo >&2 "$EXT already assigned to $TYPE"
        exit 1
    fi
) 
} 

