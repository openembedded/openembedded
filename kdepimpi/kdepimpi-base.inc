DESCRIPTION = "KDE-Pim Platform Independent - port of KDE Pim to PDA"
DESCRIPTION_kopi = "Korganizer/PI is a powerful calendar and ToDo Tool"
DESCRIPTION_kopi-applet = "KDE Pim/PI applet"
DESCRIPTION_kapi = "KAddressbook/PI is a port of KDE addressbook"
DESCRIPTION_libmicrokdelibs    = "KDE Pim/PI library - microkde"
DESCRIPTION_libkomicrokcal     = "KDE Pim/PI library - microkcal"
DESCRIPTION_libkamicrokabc     = "KDE Pim/PI library - microkabc"

SECTION = "opie/pim"
PRIORITY = "optional"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
LICENSE = "GPL"
HOMEPAGE = "http://www.pi-sync.net/ http://sf.net/projects/kdepimpi/"
#DEPENDS = "gammu libetpan libmailwrapper"
# gammu as replacement for libmicrogammu
# libetpan & libmailwrapper as replacement for kdepim/pi versions

SRC_URI += "\
file://qinputdialog_inc.patch;patch=1 \
file://manager.h.patch;patch=1 \
file://libkcal.pro.patch;patch=1 \
"

# TODO:
# checking libmailwrapper changes (diff sent to opie-devel ML)
# author said that he didn't changed libetpan so we probably can get OE one
# compile opie mail/pi

# we can't build:
# kabc/plugins/qtopia   - wants qpe/pim/  (Qtopia)
# kabc/plugins/sharpdtm - wants libsl     (Sharp ROM 3.x closed source library)
# kabc/plugins/ldap     - wants ldap libs (?)
# kabc/plugins/opie     - wants libopie1  (we don't plan to have it in OE)
# kmicromail            - have to check changes in KDEPIM/PI version libmailwrapper


S = "${WORKDIR}/kdepim"
EXTRA_QMAKEVARS_POST += "KDEPIMDIR=${S} INCLUDEPATH+=../ OBJECTS_DIR=obj/ MOC_DIR=moc/ \
			 LIBS+=-L${S}/dest/ DESTDIR=${S}/dest LIBS+=-lstdc++ \
			 LIBS+=-Wl,-rpath-link,${S}/dest \
			 "

# That changes will be needed for KMicroMail/PI to get it build with OE libs
#
#             LIBS-=-lkmicromailwrapper LIBS+=-lmailwrapper LIBS+=-lopiecore2 \

QMAKE_PROFILES= "all.pro"
SUBDIRS="libical/src/libical libical/src/libicalss microkde libkcal libkdepim \
		kabc korganizer kalarmd kaddressbook kabc/plugins/file kabc/plugins/dir \ 
		kabc/formats/binary kabc/plugins/qtopia "
#		"gammu/emb/common gammu/emb/gammu " build
#		"pwmanager/pwmanager" needs patching to link with qpe (?)

inherit palmtop

do_compile() {
	export KDEPIMDIR=${S}
	oe_runmake
}

do_configure_prepend() {
		mv ${S}/kabc/formats/binary/kabcformat_binaryE.pro ${S}/kabc/formats/binary/binaryE.pro
        echo -e "TEMPLATE=subdirs\nSUBDIRS=qtcompat ${SUBDIRS}\n" >all.pro
        for d in ${SUBDIRS}
        do
                mv -f ${d}/`basename ${d}`E.pro ${d}/`basename ${d}`.pro
        done
		mkdir "${S}/dest"
}

do_install() {
    install -d ${D}/${palmtopdir}/bin \
               ${D}/${palmtopdir}/lib \
               ${D}/${palmtopdir}/apps/1Pim \
               ${D}/${palmtopdir}/pics/kdepim/korganizer/icons16 \
               ${D}/${palmtopdir}/pics/kdepim/korganizer/iconsmini \
               ${D}/${palmtopdir}/pics/kdepim/kaddressbook/icons16 \
               ${D}/${palmtopdir}/pics/kdepim/kaddressbook/icons22 \
               ${D}/${palmtopdir}/plugins/applets

    install -m 0644 ${S}/bin/kdepim/korganizer/ko16.png ${D}/${palmtopdir}/pics/
    install -m 0644 ${S}/bin/kdepim/korganizer/ko24.png ${D}/${palmtopdir}/pics/
    install -m 0644 ${S}/bin/kdepim/korganizer/*.* ${D}/${palmtopdir}/pics/kdepim/korganizer
    install -m 0644 ${S}/bin/kdepim/korganizer/icons16/*.png ${D}/${palmtopdir}/pics/kdepim/korganizer/icons16
    install -m 0644 ${S}/bin/kdepim/korganizer/iconsmini/*.png ${D}/${palmtopdir}/pics/kdepim/korganizer/iconsmini
    install -m 0644 korganizer/korganizer.desktop ${D}/${palmtopdir}/apps/1Pim/korganizer.desktop

    install -m 0644 ${S}/bin/kdepim/kaddressbook/*.* ${D}/${palmtopdir}/pics/kdepim/kaddressbook
    install -m 0644 ${S}/bin/kdepim/kaddressbook/icons16/*.png ${D}/${palmtopdir}/pics/kdepim/kaddressbook/icons16
    install -m 0644 ${S}/bin/kdepim/kaddressbook/icons22/*.png ${D}/${palmtopdir}/pics/kdepim/kaddressbook/icons22
    install -m 0644 kaddressbook/kaddressbook.desktop ${D}/${palmtopdir}/apps/1Pim/kaddressbook.desktop

    for f in libmicrokde libmicrokdepim libkamicrokabc libkomicrokcal libmicroqtcompat libmicrokabc_file libmicrokabc_dir libmicrokabcformat_binary libmicrokabc_qtopia
    do
        oe_libinstall -so -C ${S}/dest/ $f ${D}/${palmtopdir}/lib
    done

    install -m 0755 ${S}/dest/kopi ${D}/${palmtopdir}/bin/kopi
    install -m 0755 ${S}/dest/kapi ${D}/${palmtopdir}/bin/kapi

    for f in libkopialarmapplet
    do
        oe_libinstall -so -C ${S}/dest/ $f ${D}/${palmtopdir}/plugins/applets
    done
}


PACKAGES = "libkomicrokcal libkamicrokabc kopi-applet kopi kapi libmicrokdelibs"

FILES_kopi = "${palmtopdir}/bin/kopi ${palmtopdir}/apps/1Pim/korganizer.desktop ${palmtopdir}/pics/kdepim/korganizer/* "
FILES_kapi = "${palmtopdir}/bin/kapi ${palmtopdir}/apps/1Pim/kaddressbook.desktop ${palmtopdir}/pics/kdepim/kaddressbook/* ${palmtopdir}/lib/libmicrokabc_* ${palmtopdir}/lib/libmicrokabcformat_binary*"
FILES_kopi-applet = "${palmtopdir}/plugins/applets/* ${palmtopdir}/pics/ko16.png ${palmtopdir}/pics/ko24.png"
FILES_libkamicrokabc = "${palmtopdir}/lib/libkamicrokabc*"
FILES_libkomicrokcal = "${palmtopdir}/lib/libkomicrokcal*"
FILES_libmicrokdelibs = "${palmtopdir}/lib/*"
