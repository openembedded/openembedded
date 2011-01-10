SRC_URI = "ftp://ftp.freedesktop.org/pub/mesa/${PV}/MesaLib-${PV}.tar.bz2;name=archive \
           file://glamo.patch \
           file://uclibc.patch \
          "

DEPENDS += "talloc"

SRC_URI[archive.md5sum] = "07dc6cfb5928840b8b9df5bd1b3ae434"
SRC_URI[archive.sha256sum] = "403986cd83d957db17957f11c320c9562cc8675273efbaa402e88bf4e6586721"

EXTRA_OECONF += " --disable-gallium"

do_configure_prepend() {
  #check for python not python2, because python-native does not stage python2 binary/link
  sed -i 's/AC_CHECK_PROGS(\[PYTHON2\], \[python2 python\])/AC_CHECK_PROGS(\[PYTHON2\], \[python python\])/g' ${S}/configure.ac
}
