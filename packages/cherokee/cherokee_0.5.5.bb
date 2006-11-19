PR = "r2"

SRC_URI_append = "file://configure.in.patch;patch=1 \
                  file://Makefile.am.patch;patch=1"

require cherokee.inc
