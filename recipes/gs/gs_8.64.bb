DESCRIPTION = "An interpreter of the Postscript language"
LICENSE = "GPL"
SECTION = "console/utils"
HOMEPAGE = "http://www.gnu.org/software/ghostscript/ghostscript.html"
DEPENDS = "jpeg zlib fontconfig cups"
PR = "r2"

SRC_URI = "${DEBIAN_MIRROR}/main/g/ghostscript/ghostscript_${PV}~dfsg.orig.tar.gz;name=tarball \
           file://0001_svn_snapshot.patch;patch=1 \
           file://0002_svn_snapshot_jbig2dec.patch;patch=1 \
           file://1001_install_cjk_examples.patch;patch=1 \
           file://1002_ps2pdf_man_fix.patch;patch=1 \
           file://1003_fix_autoconf_create_from_infiles.patch;patch=1 \
           file://1004_CVE-2009-0792_CVE-2009-0584_CVE-2009-0583.patch;patch=1 \
           file://1006_system-jasper.patch;patch=1 \
           file://1007_fix_pphs_script_not_lib.patch;patch=1 \
           file://2001_docdir_fix_for_debian.patch;patch=1 \
           file://2002_gs_man_fix_debian.patch;patch=1 \
           "

SRC_URI[tarball.md5sum] = "e42706c2409815df5c959484080fd4a3"
SRC_URI[tarball.sha256sum] = "cc856d33cb781cdc3383b8eb4e0f390997f8359fe144a906b84297b5d377f03d"


S = "${WORKDIR}/ghostscript-${PV}~dfsg"

inherit autotools

EXTRA_OECONF = "--without-x --with-jasper --with-zlib=${STAGING_DIR_HOST}${layout_prefix}"

TARGET_CC_ARCH += "${LDFLAGS}"

PACKAGES += "cups-gs"

do_configure() {
	# hack script to allow for cross compiling
	sed 's,&& ./configure$,& --host=\$host --build=\$build --target=\$target,g' -i configure
 
	gnu-configize
	oe_runconf
}

do_stage () {
	install -d ${STAGING_INCDIR}/ghostscript
	install -m 755 ${S}/psi/*.h ${STAGING_INCDIR}/ghostscript/
	oe_libinstall -so -C sobin libgs ${STAGING_LIBDIR}
}

do_compile_append () {
        oe_runmake so
}

do_install_append () {
        oe_runmake 'DESTDIR=${D}' soinstall
}

FILES_${PN} += "${datadir}/ghostscript"
FILES_cups-gs = "${libdir}/cups/filter/* ${datadir}/cups ${sysconfdir}/cups"

RDEPENDS_cups-gs += "gs"
