require rsync.inc

SRC_URI += "\
  file://m4.patch;patch=1 \
  file://rsyncd.conf \
"
# The source tarball from 3.0.6 seems to need this
do_configure_append(){
  oe_runmake reconfigure
}

SRC_URI[md5sum] = "e9865d093a18e4668b9d31b635dc8e99"
SRC_URI[sha256sum] = "33cc969364cb66b3e345fa7db2c651a8e07de0e58743ec03899c4ba86953e1b3"
