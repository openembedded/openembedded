require libxine.inc

PR = ${INC_PR}.0

PPDIR = "1.29"

SRC_URI += " \
    	file://libxine-arm-configure.patch \
	file://iconv.patch \
	file://ffmpeg_headers.patch \
        file://ldl.patch \
        "

python populate_packages_prepend () {
        bb.data.setVar('PKG_libxine', 'libxine', d)

        plugindir = bb.data.expand('${libdir}/xine/plugins/${PPDIR}', d)
        do_split_packages(d, plugindir, '^xineplug_(.*)\.so$', 'libxine-plugin-%s', 'Xine plugin for %s', extra_depends='' )

	vidixdir = bb.data.expand('${libdir}/xine/plugins/${PPDIR}/vidix', d)
        do_split_packages(d, vidixdir, '^(.*)\.so$', 'libxine-plugin-%s', 'Xine plugin for %s', extra_depends='' )

        postdir = bb.data.expand('${libdir}/xine/plugins/${PPDIR}/post', d)
        do_split_packages(d, postdir, '^xineplug_(.*)\.so$', 'libxine-plugin-%s', 'Xine plugin for %s', extra_depends='' )

        fontdir = bb.data.expand('${datadir}/xine/libxine1/fonts', d)
        do_split_packages(d, fontdir, '^(.*).xinefont.gz$', 'libxine-font-%s', 'Xine font %s', extra_depends='' )

}

FILES_${PN}-dbg =+ "${libdir}/xine/plugins/${PPDIR}/.debug \
		    ${libdir}/xine/plugins/${PPDIR}/post/.debug \
		    ${libdir}/xine/plugins/${PPDIR}/vidix/.debug \
	           "

FILES_${PN}-dev =+ "${libdir}/xine/plugins/${PPDIR}/*.a \
                    ${libdir}/xine/plugins/${PPDIR}/post/*.a \
                    ${libdir}/xine/plugins/${PPDIR}/vidix/*.a \
                   "

SRC_URI[md5sum] = "a410a0f0617e1d6309f0cbe907f73f8a"
SRC_URI[sha256sum] = "6277c6c5343ad45027492d0b3437f1894b3d34fd9b292638da2bf4ae749d8774"
