DESCRIPTION = "KDE-Pim Platform Independent - port of KDE Pim to PDA"
DESCRIPTION_kopi = "Korganizer/PI is a powerful calendar and ToDo Tool"
DESCRIPTION_kopi-applet = "KDE Pim/PI applet"
DESCRIPTION_kapi = "KAddressbook/PI is a port of KDE addressbook"
DESCRIPTION_libmicrokdelibs  = "KDE Pim/PI library - microkde"
DESCRIPTION_libmicrokcal     = "KDE Pim/PI library - microkcal"
DESCRIPTION_libmicrokabc     = "KDE Pim/PI library - microkabc"
DESCRIPTION_libmicrokammu    = "KDE Pim/PI fork of libGammu"
DESCRIPTION_kammu            = "KDE Pim/PI fork of gammu"

SECTION = "opie/pim"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://www.pi-sync.net/ http://sf.net/projects/kdepimpi/"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"

# we can't build:
# kabc/plugins/sharpdtm - wants libsl     (Sharp ROM 3.x closed source library)
# kabc/plugins/ldap     - wants ldap libs (?)
# kabc/plugins/opie     - wants libopie1  (we don't plan to have it in OE)
# kmicromail            - conflict with OE libetpan, libmailwrapper/OPIE

PARALLEL_MAKE = ""

S = "${WORKDIR}/kdepim"

EXTRA_QMAKEVARS_POST += " \
INCLUDEPATH+=../ \
OBJECTS_DIR=obj/ MOC_DIR=moc/ \
DESTDIR=${S}/dest \
LIBS+=-L${S}/dest/ \
LIBS-=-lzlib \
LIBS+=-lz \
"
# That changes will be needed for KMicroMail/PI to get it build with OE libs
#
#             LIBS-=-lkmicromailwrapper LIBS+=-lmailwrapper LIBS+=-lopiecore2 \

QMAKE_PROFILES= "all.pro"

SUBDIRS="qtcompat libical/src/libical libical/src/libicalss microkde libkcal libkdepim \
        kabc korganizer kalarmd kaddressbook kabc/plugins/file kabc/plugins/dir \
        kabc/formats/binary kabc/plugins/qtopia \
        gammu/emb/common \
        gammu/emb/gammu \
#        pwmanager/libcrypt/mpi  \
#        pwmanager/libcrypt/error  \
#        pwmanager/libcrypt/cipher  \
#        pwmanager/libcrypt/zlib \
#        pwmanager/pwmanager \
        "

inherit palmtop

do_configure_prepend() {
        mv ${S}/kabc/formats/binary/kabcformat_binaryE.pro ${S}/kabc/formats/binary/binaryE.pro
        echo -e "TEMPLATE=subdirs\nSUBDIRS=${SUBDIRS}\n" >all.pro
        for d in ${SUBDIRS}
        do
            if [ -f ${d}/`basename ${d}`E.pro ]; 
            then
                mv -f ${d}/`basename ${d}`E.pro ${d}/`basename ${d}`.pro
            fi
        done
}

do_compile() {
    export KDEPIMDIR=${S}
    oe_runmake
}

HEADERS_DIRS = "qtcompat \
microkde \
microkde/kdecore \
microkde/kdeui \
microkde/kio \
microkde/kresources \
microkde/kutils \
microkde/opie2 \
kabc \
libkcal \
libkdepim "

do_unstage() {

	for dir in ${HEADERS_DIRS};
	do
		rm -rf ${STAGING_INCDIR}/kdepimpi/$dir
	done

    for f in libmicrokde libmicrokdepim libmicrokabc libmicrokcal libmicroqtcompat
    do
        rm -f ${STAGING_LIBDIR}/kdepimpi/$f*
    done
}

addtask unstage before do_configure

do_stage() {

	for dir in ${HEADERS_DIRS};
	do
		install -d ${STAGING_INCDIR}/kdepimpi/$dir
		install -m 0644 ${S}/$dir/*.h ${STAGING_INCDIR}/kdepimpi/$dir/
	done

    for f in libmicrokde libmicrokdepim libmicrokabc libmicrokcal libmicroqtcompat
    do
        oe_libinstall -so -C ${S}/dest/ $f ${STAGING_LIBDIR}/kdepimpi/
    done
}

do_install() {
    install -d ${D}${palmtopdir}/bin \
               ${D}${palmtopdir}/lib \
               ${D}${palmtopdir}/apps/1Pim \
               ${D}${palmtopdir}/pics/kdepim/korganizer/icons16 \
               ${D}${palmtopdir}/pics/kdepim/korganizer/iconsmini \
               ${D}${palmtopdir}/pics/kdepim/kaddressbook/icons16 \
               ${D}${palmtopdir}/pics/kdepim/kaddressbook/icons22 \
               ${D}${palmtopdir}/plugins/applets

    install -m 0644 ${S}/bin/kdepim/korganizer/ko16.png ${D}${palmtopdir}/pics/
    install -m 0644 ${S}/bin/kdepim/korganizer/ko24.png ${D}${palmtopdir}/pics/
    install -m 0644 ${S}/bin/kdepim/korganizer/*.* ${D}${palmtopdir}/pics/kdepim/korganizer
    install -m 0644 ${S}/bin/kdepim/korganizer/icons16/*.png ${D}${palmtopdir}/pics/kdepim/korganizer/icons16
    install -m 0644 ${S}/bin/kdepim/korganizer/iconsmini/*.png ${D}${palmtopdir}/pics/kdepim/korganizer/iconsmini
    install -m 0644 korganizer/korganizer.desktop ${D}${palmtopdir}/apps/1Pim/korganizer.desktop

    install -m 0644 ${S}/bin/kdepim/kaddressbook/*.* ${D}${palmtopdir}/pics/kdepim/kaddressbook
    install -m 0644 ${S}/bin/kdepim/kaddressbook/icons16/*.png ${D}${palmtopdir}/pics/kdepim/kaddressbook/icons16
    install -m 0644 ${S}/bin/kdepim/kaddressbook/icons22/*.png ${D}${palmtopdir}/pics/kdepim/kaddressbook/icons22
    install -m 0644 kaddressbook/kaddressbook.desktop ${D}${palmtopdir}/apps/1Pim/kaddressbook.desktop

    for f in libmicrokde libmicrokdepim libmicrokabc libmicrokcal libmicroqtcompat libmicrokabc_file libmicrokabc_dir libmicrokabcformat_binary libmicrokabc_qtopia 
    do
        oe_libinstall -so -C ${S}/dest/ $f ${D}${palmtopdir}/lib
    done

    install -m 0755 ${S}/dest/kopi ${D}${palmtopdir}/bin/kopi
    install -m 0755 ${S}/dest/kapi ${D}${palmtopdir}/bin/kapi
    
    install -d ${D}${bindir} ${D}${libdir}
    install -m 0755 ${S}/dest/kammu ${D}${bindir}/kammu
    oe_libinstall -so -C ${S}/dest/ libmicrokammu ${D}${libdir}

    for f in libkopialarmapplet
    do
        oe_libinstall -so -C ${S}/dest/ $f ${D}${palmtopdir}/plugins/applets
    done
}


PACKAGES = "libmicrokcal libmicrokabc kopi-applet kopi kapi libmicrokdelibs kammu libmicrokammu"

FILES_kopi = "${palmtopdir}/bin/kopi ${palmtopdir}/apps/1Pim/korganizer.desktop ${palmtopdir}/pics/kdepim/korganizer/* "
FILES_kapi = "${palmtopdir}/bin/kapi ${palmtopdir}/apps/1Pim/kaddressbook.desktop ${palmtopdir}/pics/kdepim/kaddressbook/* ${palmtopdir}/lib/libmicrokabc_* ${palmtopdir}/lib/libmicrokabcformat_binary*"
FILES_kopi-applet = "${palmtopdir}/plugins/applets/* ${palmtopdir}/pics/ko16.png ${palmtopdir}/pics/ko24.png"
FILES_libmicrokabc = "${palmtopdir}/lib/libmicrokabc*"
FILES_libmicrokcal = "${palmtopdir}/lib/libmicrokcal*"
FILES_libmicrokdelibs = "${palmtopdir}/lib/*"
FILES_kammu = "${bindir}/kammu"
FILES_libmicrokammu = "${libdir}/libmicrokammu*"
