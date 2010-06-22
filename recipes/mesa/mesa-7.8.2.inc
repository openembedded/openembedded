SRC_URI += " \ 
            file://fix-progs-makefile.patch \
            file://glamo.patch \
           "

SRC_URI[archive.md5sum] = "6be2d343a0089bfd395ce02aaf8adb57"
SRC_URI[archive.sha256sum] = "505bf418dceba05837f4ea1b1972b9620c35f8cb94bc4d1e6d573c15f562576d"
SRC_URI[demos.md5sum] = "757d9e2e06f48b1a52848be9b0307ced"
SRC_URI[demos.sha256sum] = "ea7b9ebfb7a80de2b275c0c9124c8a505382ec48411a2794ab82542f9885ac3c"

DEFAULT_PREFERENCE_shr = "2"

EXTRA_OECONF += " --disable-gallium"
