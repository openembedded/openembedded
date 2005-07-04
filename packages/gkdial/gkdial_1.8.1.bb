inherit autotools pkgconfig gconf

DESCRIPTION = "GTK PPP dialing tool"
DEPENDS = "gconf-dbus gtk+ libglade gettext ppp gpe-su"
RDEPENDS = "ppp gconf-dbus gpe-su"
MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"
SECTION = "gpe"
PRIORITY = "optional"

PR = "r3gpe1"

SRC_URI = "http://familiar.handhelds.org/source/v0.8.2/${PN}-${PV}.tar.gz \
           file://gkdial-pgpe.patch;patch=1 \
           file://gkdial-ungnome.patch;patch=1;pnum=0 \
           file://gkdial-gladedir.patch;patch=1;pnum=0 \
           file://gkdial-gpepda.patch;patch=1;pnum=1 \
           file://gkdial.desktop \
           file://gkdial.png"

FILES_${PN} = "${sysconfdir}/chatscripts ${bindir} ${datadir}/pixmaps ${datadir}/applications"
FILES_${PN} += " ${datadir}/gkdial ${datadir}/gkdial/glade ${sysconfdir}/gconf/schemas"
 
CFLAGS_append = " -I${STAGING_KERNEL_DIR}/include -D_GNU_SOURCE"
LDFLAGS_append = " -Wl,--export-dynamic"

do_install_append () {
        mkdir -p  ${D}${datadir}/pixmaps
        install -m 0644 ${WORKDIR}/gkdial.png ${D}${datadir}/pixmaps/gkdial.png
        mkdir -p  ${D}${datadir}/applications
        install -m 0644 ${WORKDIR}/gkdial.desktop ${D}${datadir}/applications/gkdial.desktop
	mkdir -p ${D}${sysconfdir}/chatscripts
        mkdir -p ${D}${sysconfdir}/gconf/schemas
        install -m 0644 ${S}/gkdial.schemas ${D}${sysconfdir}/gconf/schemas/gkdial.schemas
}
