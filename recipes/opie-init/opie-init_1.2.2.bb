require ${PN}.inc
PR = "r9"

SRC_URI = "file://opie-reorgfiles \
           file://opie \
           file://qpe.conf \
           file://locale.conf \
           file://opie_defaults"

SRC_URI_append_c7x0 = " file://qpe-suspend-resume"
