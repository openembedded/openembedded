LICENSE = "GPL"
SECTION = "x11/gnome"
PR = "r0"
DESCRIPTION = "Common macros for building GNOME applications"
inherit gnome

# The omf.make file failed if scrollkeeper doesn't happen to be
# installed

SRC_URI += "file://omf.patch;patch=1"

EXTRA_AUTORECONF = ""
DEPENDS = ""

FILES_${PN} += "${datadir}/aclocal"
FILES_${PN}-dev = ""

do_stage () {
	rm -rf ${STAGE_TEMP}
	mkdir -p ${STAGE_TEMP}
	make DESTDIR="${STAGE_TEMP}" install
	cp -a ${STAGE_TEMP}${bindir}/* ${STAGING_DIR}/${BUILD_SYS}/bin
	install -d ${STAGING_DIR}/${HOST_SYS}/share/gnome-common
	cp -a ${STAGE_TEMP}${datadir}/gnome-common/* ${STAGING_DIR}/${HOST_SYS}/share/gnome-common
	cp -a ${STAGE_TEMP}${datadir}/aclocal/* ${STAGING_DIR}/${HOST_SYS}/share/aclocal
	rm -rf ${STAGE_TEMP}
}
