DESCRIPTION = "Auto-Correction Paint Program for Opie/Qtopia"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "FreeNote"
APPTYPE = "binary"
APPDESKTOP = "apps/Applications"

SRC_URI = "http://www.urban.ne.jp/home/kanemori/zaurus/FreeNote_1.12.0.tar.gz \
           file://FreeNote"
S = "${WORKDIR}/FreeNote"

inherit opie

do_configure_prepend() {
	mv -f FreeNote subdir1
	mv -f FreeNoteSetup subdir2
	printf "TEMPLATE=subdirs\nSUBDIRS=subdir1 subdir2\n" >> freenote.pro
	cd ${S}/subdir1 && rm *.pro && qmake -project && echo "TARGET=FreeNote" >> subdir1.pro
	cd ${S}/subdir2 && rm *.pro && qmake -project && echo "TARGET=FreeNoteSetup" >> subdir2.pro
	cd ${S}
}

do_install() {
	install -d ${D}${palmtopdir}/bin/
	install -m 0755 FreeNoteSetup ${D}${palmtopdir}/bin/
	install -d ${D}${palmtopdir}/pics/
	install -m 0644 pics/freenote.png ${D}${palmtopdir}/pics
	install -m 0644 pics/fnsetup.png ${D}${palmtopdir}/pics
	install -d ${D}${palmtopdir}/apps/Applications
	install -m 0644 apps/Applications/FreeNote.desktop ${D}${palmtopdir}/apps/Applications
	install -d ${D}${palmtopdir}/apps/Settings
	install -m 0644 apps/Settings/FreeNoteSetup.desktop ${D}${palmtopdir}/apps/Settings
}

SRC_URI[md5sum] = "06b5aeb6cc97107090438a364f0ce89b"
SRC_URI[sha256sum] = "e6a0a5b674c4803bfd1ffda9660c29f4399294623ed095b0d1c554367c7db73c"
