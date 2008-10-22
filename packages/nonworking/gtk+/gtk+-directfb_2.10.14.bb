require gtk-2.10.inc

PR = "r2"

# disable per default - untested and not all patches included.
DEFAULT_PREFERENCE = "-1"
S = "${WORKDIR}/gtk+-${PV}"


RCONFLICTS = "gtk+"
RPROVIDES ="gtk+-directfb"
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
           file://no-xwc.patch;patch=1 \
           file://automake-lossage.patch;patch=1 \
           file://disable-tooltips.patch;patch=1 \
           file://gtklabel-resize-patch;patch=1 \
           file://menu-deactivate.patch;patch=1 \
           file://xsettings.patch;patch=1 \
           file://scroll-timings.patch;patch=1 \
           file://small-gtkfilesel.patch;patch=1 \
           file://migration.patch;patch=1;pnum=0 \
           file://run-iconcache.patch;patch=1 \
           file://hardcoded_libtool.patch;patch=1 \
           file://no-demos.patch;patch=1 \
           file://single-click.patch;patch=1 \
           file://spinbutton.patch;patch=1 \
           file://gtk+-handhelds.patch;patch=1 \
	   file://directfb-pixbuf-deprecated-fix.patch;patch=1 \
#	   file://gtk-doc.patch;patch=1 \
"
EXTRA_OECONF =" \
                --prefix=${STAGING_DIR_HOST}${layout_prefix} \
                --with-gdktarget=directfb \
                --without-x \
                --without-libtiff \
                "
GDKTARGET="directfb"

