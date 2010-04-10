require bison.inc

PR = "${INCPR}.0"

# >> bison-2.3-r0: /usr/lib/liby.a
# That one is a special case: it wants to stay in the main bison package,
# since bison itself is a development tool.  I'm not sure why it is a
# static-only library; that might be an error.

FILES_${PN} += "${libdir}/liby.a"

SRC_URI[md5sum] = "22327efdd5080e2b1acb6e560a04b43a"
SRC_URI[sha256sum] = "52f78aa4761a74ceb7fdf770f3554dd84308c3b93c4255e3a5c17558ecda293e"
