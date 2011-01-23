require vdr.inc
PR = "r2"

SRC_URI += "file://0001-Makefile-Pass-LDFLAGS.patch \
            file://0002-tools.h-include-stdarg.h.patch \
           "

SRC_URI_append_libc-uclibc = " file://0003-uclibc-Add-lintl-to-LIBS.patch "
SRC_URI_append_uclinux-uclibc = " file://0003-uclibc-Add-lintl-to-LIBS.patch "

EXTRA_OEMAKE += "INCLUDES=-I${STAGING_INCDIR}/freetype2"

PLUGINDIR = "${libdir}/vdr/plugins"

do_install () {
      oe_runmake 'DESTDIR=${D}' \
                 'PREFIX=${prefix}' \
                 'CONFDIR=${sysconfdir}/vdr' \
                 'VIDEODIR=/var/lib/vdr/video' \
                 'PLUGINLIBDIR=${PLUGINDIR}' \
                 'LOCDIR=${datadir}/locale' \
                 install
}

PACKAGES_DYNAMIC += "vdr-plugin-*"

python populate_packages_prepend () {
        plugindir = bb.data.expand('${PLUGINDIR}', d)
        do_split_packages(d, plugindir, '^libvdr-(.*)\.so*', 'libvdr-%s', 'vdr plugin %s',  extra_depends='')
}

FILES_${PN} = "${bindir}/* /var/lib/vdr/conf/* ${sysconfdir}/*"
FILES_${PN}-dbg += "${PLUGINDIR}/.debug/*"

SRC_URI[md5sum] = "d5cc4bf87e73385a843f5de4763639f0"
SRC_URI[sha256sum] = "f760d196c6f976043774f6ad9ba1af956d24ad456f8b2fea7dd6a73d38c96e95"
