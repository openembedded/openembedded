DESCRIPTION = "An interpreter of the Postscript language"
LICENSE = "GPLv2"
SECTION = "console/utils"
HOMEPAGE = "http://www.gnu.org/software/ghostscript/ghostscript.html"
DEPENDS = "jpeg zlib fontconfig cups gs-tools-native"
PR = "r4"

SRC_URI = "${DEBIAN_MIRROR}/main/g/ghostscript/ghostscript_${PV}~dfsg.orig.tar.gz;name=tarball \
           file://0001_svn_snapshot.patch \
           file://0002_svn_snapshot_jbig2dec.patch \
           file://1001_install_cjk_examples.patch \
           file://1002_ps2pdf_man_fix.patch \
           file://1003_fix_autoconf_create_from_infiles.patch \
           file://1004_CVE-2009-0792_CVE-2009-0584_CVE-2009-0583.patch \
           file://1006_system-jasper.patch \
           file://1007_fix_pphs_script_not_lib.patch \
           file://2001_docdir_fix_for_debian.patch \
           file://2002_gs_man_fix_debian.patch \
           file://unix-aux.mak \
           "

SRC_URI[tarball.md5sum] = "e42706c2409815df5c959484080fd4a3"
SRC_URI[tarball.sha256sum] = "cc856d33cb781cdc3383b8eb4e0f390997f8359fe144a906b84297b5d377f03d"

S = "${WORKDIR}/ghostscript-${PV}~dfsg"

inherit autotools

EXTRA_OECONF = "--without-x --with-jasper --with-zlib=${STAGING_DIR_HOST}${layout_prefix} --with-fontpath=${datadir}/fonts"

TARGET_CC_ARCH += "${LDFLAGS}"

PACKAGES += "cups-gs"

do_configure() {
        # hack script to allow for cross compiling jasper
        sed 's,&& ./configure$,& --host=\$host --build=\$build --target=\$target,g' -i configure
        gnu-configize
        CFLAGS="${CFLAGS} -fPIC" oe_runconf
}

do_configure_append() {
        # copy tools from the native gs build
        mkdir -p obj soobj
        for i in genarch genconf mkromfs echogs gendev genht; do
                cp ${STAGING_BINDIR_NATIVE}/gs-tools-${PV}/$i obj/$i
                cp ${STAGING_BINDIR_NATIVE}/gs-tools-${PV}/$i soobj/$i
        done
        # Prevent mkromfs from being recompiled for the target
        cp ${WORKDIR}/unix-aux.mak base/
}

do_compile_append () {
        oe_runmake CFLAGS="${CFLAGS} -fPIC" so
}

do_install_prepend () {
        sed -e 's#CUPSSERVERBIN=${STAGING_LIBDIR}/cups#CUPSSERVERBIN=${libdir}/cups#g' -i ${S}/Makefile
        sed -e 's#CUPSDATA=${STAGING_DATADIR}/cups#CUPSDATA=${datadir}/cups#g' -i ${S}/Makefile
}

do_install_append () {
        oe_runmake 'DESTDIR=${D}' soinstall
	# recent cups expects this file in /usr/share/cups/mime
	# so duplicate it for compatibility
	mkdir -p ${D}/${datadir}/cups/mime/
        cp ${D}/etc/cups/pstoraster.convs ${D}/${datadir}/cups/mime/

	install -d ${D}${incluedir}/ghostscript
	install -m 644 ${S}/psi/*.h ${D}${includedir}/ghostscript/
}

FILES_${PN} += "${datadir}/ghostscript"
FILES_cups-gs = "${libdir}/cups/filter/ ${datadir}/cups ${sysconfdir}/cups"

RDEPENDS_cups-gs += "gs"
