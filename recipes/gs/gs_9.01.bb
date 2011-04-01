DESCRIPTION = "An interpreter of the Postscript language"
LICENSE = "GPL"
SECTION = "console/utils"
HOMEPAGE = "http://www.gnu.org/software/ghostscript/ghostscript.html"
DEPENDS = "jpeg fontconfig cups"
PR = "r0"

SRC_URI = "http://downloads.ghostscript.com/public/ghostscript-${PV}.tar.gz;name=tarball \
           file://unix-aux.mak \
           "

SRC_URI[tarball.md5sum] = "5352c1c542cfabe928cfd3a17db051ad"
SRC_URI[tarball.sha256sum] = "2259d2b6a819d8a6daed274681c8de43996ae1767b20bfa0fc78e37a5be96a8b"

S = "${WORKDIR}/ghostscript-${PV}"

inherit autotools

EXTRA_OECONF = "--without-x --with-jasper --with-fontpath=${datadir}/fonts"

TARGET_CC_ARCH += "${LDFLAGS}"

PACKAGES += "cups-gs"

do_configure_prepend() {
        CC="${BUILD_CC}" LD="${BUILD_LD}" ./configure
        mkdir obj
        for i in genarch genconf mkromfs echogs gendev genht; do
                make obj/$i
        done
        mv obj obj_host
        make clean
}

do_configure() {
	# hack script to allow for cross compiling
	sed 's,&& ./configure$,& --host=\$host --build=\$build --target=\$target,g' -i configure
 
	gnu-configize
	oe_runconf
}

do_configure_append() {
        if [ ! -d obj ]; then
                mkdir obj
        fi
        if [ ! -d soobj ]; then
                mkdir soobj
        fi
        for i in genarch genconf mkromfs echogs gendev genht; do
                cp obj_host/$i obj/$i
                cp obj_host/$i soobj/$i
        done
        # Prevent mkromfs from being recompiled for the target
        cp ${WORKDIR}/unix-aux.mak base/
}

do_stage () {
	install -d ${STAGING_INCDIR}/ghostscript
	install -m 755 ${S}/psi/*.h ${STAGING_INCDIR}/ghostscript/
	oe_libinstall -so -C sobin libgs ${STAGING_LIBDIR}
}

do_compile_append () {
        oe_runmake so
}

do_install_prepend () {
        sed -e 's#CUPSSERVERBIN=${STAGING_LIBDIR}/cups#CUPSSERVERBIN=${libdir}/cups#g' -i ${S}/Makefile
        sed -e 's#CUPSDATA=${STAGING_DATADIR}/cups#CUPSDATA=${datadir}/cups#g' -i ${S}/Makefile
	# 64 bit Ubuntu cp fails if file exists, so use -f option
        sed -e 's#CP_=cp#CP_=cp -f#g' -i ${S}/base/unixhead.mak

}

do_install_append () {
        oe_runmake 'DESTDIR=${D}' soinstall
	# recent cups expects this file in /usr/share/cups/mime
	# so duplicate it for compatibility
	mkdir -p ${D}/${datadir}/cups/mime/
        cp ${D}/etc/cups/pstoraster.convs ${D}/${datadir}/cups/mime/
}

FILES_${PN} += "${datadir}/ghostscript "
FILES_${PN}-dbg += "${libdir}/cups/filter/.debug/ "
FILES_cups-gs += "${libdir}/cups/filter/ ${datadir}/cups/ ${sysconfdir}/cups/*.convs "

RDEPENDS_cups-gs += "gs"
