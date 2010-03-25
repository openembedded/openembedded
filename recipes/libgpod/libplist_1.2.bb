DESCRIPTION = "A library to handle Apple Property List format whereas it's binary or XML"
LICENSE = "GPLv2/LGPLv2.1"

DEPENDS = "libxml2 glib-2.0 swig python"

inherit cmake pkgconfig

SRC_URI = "http://github.com/downloads/JonathanBeck/libplist/libplist-${PV}.tar.bz2;name=archive"
SRC_URI[archive.md5sum] = "a29e98e51977253f09a912c942f37a68"
SRC_URI[archive.sha256sum] = "e8223809af55283188e8a1adfe97a59655c788f6d3048a7624f648d007f87558"

LIBV = "0.10"

python populate_packages_prepend () {
	glibdir = bb.data.expand('${libdir}', d)
	do_split_packages(d, glibdir, '^lib(.*)\.so\.*', 'lib%s', 'libplist %s library', extra_depends='', allow_links=True)
}

FILES_${PN} = "${libdir}/${PN}.so.*"
PACKAGES =+ "${PN}-utils"
FILES_${PN}-utils = "${bindir}/*"

