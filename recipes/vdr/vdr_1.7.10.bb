require vdr.inc
PR = "r3"

SRC_URI += " file://fixpaths.patch;patch=1 \
           file://cplusplus.patch;patch=1 \
           file://disable_plugin.patch;patch=1 \
           file://linkerflags.patch;patch=1 \
          "

SRC_URI_append_linux-uclibceabi = " file://libintl.patch;patch=1 "
SRC_URI_append_uclinux-uclibc = " file://libintl.patch;patch=1 "

CFLAGS_append += " -I${STAGING_INCDIR}/freetype2"

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
