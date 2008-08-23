DESCRIPTION = "KDE-Pim Platform Independent - port of KDE Pim to PDA - X11 version"
DESCRIPTION_kopi-x11 = "Korganizer/PI is a powerful calendar and ToDo Tool - X11 version"
DESCRIPTION_kopi-applet-x11 = "KDE Pim/PI applet - X11 version"
DESCRIPTION_kapi-x11 = "KAddressbook/PI is a port of KDE addressbook - X11 version"
DESCRIPTION_libmicrokdelibs-x11  = "KDE Pim/PI library - microkde - X11 version"
DESCRIPTION_libmicrokcal-x11     = "KDE Pim/PI library - microkcal - X11 version"
DESCRIPTION_libmicrokabc-x11     = "KDE Pim/PI library - microkabc - X11 version"
DESCRIPTION_libmicrokammu-x11    = "KDE Pim/PI fork of libGammu - X11 version"
DESCRIPTION_kammu-x11            = "KDE Pim/PI fork of gammu - X11 version"

SECTION = "x11/pim"

inherit qmake qt3x11

QMAKE_PROFILES= "kdepim-desktop.pro"

do_install() {
		oe_runmake install
}

do_install-broken() {
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

PACKAGES = "libmicrokcal-x11 libmicrokabc-x11 kopi-applet-x11 kopi-x11 kapi-x11 libmicrokdelibs-x11 kammu-x11 libmicrokammu-x11 ${PN}"

FILES_kopi-x11 = "${palmtopdir}/bin/kopi ${palmtopdir}/apps/1Pim/korganizer.desktop ${palmtopdir}/pics/kdepim/korganizer/* "
FILES_kapi-x11 = "${palmtopdir}/bin/kapi ${palmtopdir}/apps/1Pim/kaddressbook.desktop ${palmtopdir}/pics/kdepim/kaddressbook/* ${palmtopdir}/lib/libmicrokabc_* ${palmtopdir}/lib/libmicrokabcformat_binary*"
FILES_kopi-applet-x11 = "${palmtopdir}/plugins/applets/* ${palmtopdir}/pics/ko16.png ${palmtopdir}/pics/ko24.png"
FILES_libmicrokabc-x11 = "${palmtopdir}/lib/libmicrokabc*"
FILES_libmicrokcal-x11 = "${palmtopdir}/lib/libmicrokcal*"
FILES_libmicrokdelibs-x11 = "${palmtopdir}/lib/*"
FILES_kammu-x11 = "${bindir}/kammu"
FILES_libmicrokammu-x11 = "${libdir}/libmicrokammu*"
