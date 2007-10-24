DESCRIPTION = "O-Hand Jana Library"
DEPENDS = "libmokojournal2 gtk+ eds-dbus" 
PV = "0.1.0+svnr${SRCREV}"
PR = "r2"

inherit autotools pkgconfig lib_package

SRC_URI = "svn://svn.o-hand.com/repos/dates/branches;module=jana;proto=http \
           file://clockpatch.patch;patch=1"
S = "${WORKDIR}/jana/"

do_configure_prepend() {
	touch gtk-doc.make
}

do_stage() {
	autotools_stage_all
}

PACKAGES = "libjana-ecal libjana-ecal-dbg \
            libjana-gtk libjana-gtk-dbg \ 
            libjana libjana-dbg libjana-dev \
"

FILES_libjana-ecal = "${libdir}/libjana.so.*"
FILES_libjana-ecal-dbg = "${libdir}/.debug/libjana-ecal*"
FILES_libjana-gtk = "${libdir}/libjana-gtk.so.*"
FILES_libjana-gtk-dbg = "${libdir}/.debug/libjana-gtk.so.*"
FILES_libjana = "${libdir}/libjana.so.*"
FILES_libjana-dbg = "${libdir}/.debug/libjana.so.*"
