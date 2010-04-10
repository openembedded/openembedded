require rsync.inc

PR = "r1"

SRC_URI += "\
  file://m4.patch;patch=1 \
  file://rsyncd.conf \
"

do_compile_prepend() {
        sed -i "s/conf_stop make_stop//" Makefile
}

SRC_URI[md5sum] = "2122d460b4119749c6e5993938a9b501"
SRC_URI[sha256sum] = "17697db5bb9de399b71f7927070f60b3554b70b0ecc0419b50455d56560ea169"
