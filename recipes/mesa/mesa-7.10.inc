SRC_URI = "ftp://ftp.freedesktop.org/pub/mesa/${PV}/MesaLib-${PV}.tar.bz2;name=archive \
           file://glamo.patch \
           file://uclibc.patch \
          "

DEPENDS += "talloc"

SRC_URI[archive.md5sum] = "33fb94eccc02cbb4d8d1365615e38e46"
SRC_URI[archive.sha256sum] = "bcf28f43f39c28da271c0f5857fb32898d4ade3e035e80a0ceece1c2df6e0aca"

EXTRA_OECONF += " --disable-gallium"

#needs more testing and updated glamo.patch before making default
DEFAULT_PREFERENCE = "-2"

do_configure_prepend() {
  #check for python not python2, because python-native does not stage python2 binary/link
  sed -i 's/AC_CHECK_PROGS(\[PYTHON2\], \[python2 python\])/AC_CHECK_PROGS(\[PYTHON2\], \[python python\])/g' ${S}/configure.ac
}
