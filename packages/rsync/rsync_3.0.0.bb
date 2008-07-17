require rsync.inc

PR = "r1"

SRC_URI += "\
  file://m4.patch;patch=1 \
  file://rsyncd.conf \
"

do_compile_prepend() {
        sed -i "s/conf_stop make_stop//" Makefile
}
