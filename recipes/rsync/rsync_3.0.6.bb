require rsync.inc

SRC_URI += "\
  file://m4.patch;patch=1 \
  file://rsyncd.conf \
"
# The source tarball from 3.0.6 seems to need this
do_configure_append(){
  oe_runmake reconfigure
}
