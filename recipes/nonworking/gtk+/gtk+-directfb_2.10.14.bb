require gtk-2.10.inc

PR = "r3"

# disable per default - untested and not all patches included.
DEFAULT_PREFERENCE = "-1"
S = "${WORKDIR}/gtk+-${PV}"


RCONFLICTS_${PN} = "gtk+"
RPROVIDES_${PN} ="gtk+-directfb"
DEPENDS = "glib-2.0 pango-directfb atk jpeg libpng gtk-doc libgcrypt cairo-directfb cups"
LDFLAGS_append += " -ldirectfb"
CFLAGS_append  += " -I${STAGING_INCDIR}/directfb"

#NEATSTUFF = " ttf-dejavu-sans gdk-pixbuf-loader-png gdk-pixbuf-loader-jpeg gdk-pixbuf-loader-gif "

#PACKAGES_DYNAMIC_${PN} = " ${NEATSTUFF} "
#PACKAGES_DYNAMIC_${PN}_linux = " ${NEATSTUFF} glibc-gconv-iso8859-1 "
#PACKAGES_DYNAMIC_${PN}_linux-gnueabi = " ${NEATSTUFF} glibc-gconv-iso8859-1"
RRECOMMENDS_${PN} = " "
RRECOMMENDS_${PN}_linux = " "
RRECOMMENDS_${PN}_linux-gnueabi = " "

FILESPATH = "${FILE_DIRNAME}/gtk+-${PV}:${FILE_DIRNAME}/files"

SRC_URI = "ftp://ftp.gtk.org/pub/gtk/v2.10/gtk+-${PV}.tar.bz2 \
           file://no-xwc.patch \
           file://automake-lossage.patch \
           file://disable-tooltips.patch \
           file://gtklabel-resize-patch;apply=yes \
           file://menu-deactivate.patch \
           file://xsettings.patch \
           file://scroll-timings.patch \
           file://small-gtkfilesel.patch \
           file://migration.patch;striplevel=0 \
           file://run-iconcache.patch \
           file://hardcoded_libtool.patch \
           file://no-demos.patch \
           file://single-click.patch \
           file://spinbutton.patch \
           file://gtk+-handhelds.patch \
	   file://directfb-pixbuf-deprecated-fix.patch \
#	   file://gtk-doc.patch \
"
EXTRA_OECONF =" \
                --prefix=${STAGING_DIR_HOST}${layout_prefix} \
                --with-gdktarget=directfb \
                --without-x \
                --without-libtiff \
                "
GDKTARGET="directfb"


SRC_URI[md5sum] = "018d7dd0fa7de01cfdb77c7c55e7ba26"
SRC_URI[sha256sum] = "d02344239d048390ba02fcfd7de4f9efc0dfb51e7b06dfa46a6314d666ea4de2"