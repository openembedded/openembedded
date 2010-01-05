DESCRIPTION = "Video Disk Recorder (VDR) is a digital sat-receiver program using Linux and DVB technologies. It allows one to record MPEG2 streams, as well as output the stream to TV. It is also possible to watch DVDs (hardware accelerated) with some comfort and use an IR remote control."
AUTHOR = "Klaus Schmidinger"
LICENSE = "GPLv2"
HOMEPAGE = "http://www.tvdr.de"
PR = "r0"

DEPENDS = "fontconfig freetype gettext libcap jpeg virtual/libintl"

SRC_URI = "ftp://ftp.tvdr.de/vdr/Developer/${P}.tar.bz2 \
           file://fixpaths.patch;patch=1 \
           file://cplusplus.patch;patch=1 \
           file://libintl.patch;patch=1 \
           file://disable_plugin.patch;patch=1 \
           file://linkerflags.patch;patch=1 \
          "

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

FILES_${PN} = "${bindir}/* /var/lib/vdr/conf/*"
FILES_${PN}-dbg += "${PLUGINDIR}/.debug/*"

