require ${PN}.inc
PR = "r0"

SRC_URI = "file://opie-reorgfiles \
           file://opie \
           file://qpe.conf \
           file://locale.conf \
           file://opie_defaults"

# This should not be necessary anymore (w100 is currently disabled for c7x0)
#SRC_URI_append_c7x0 = " file://qpe-suspend-resume"
