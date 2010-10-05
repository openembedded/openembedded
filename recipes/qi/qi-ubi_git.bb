require qi_git.bb

# workaround for (in this case) harmless error during image build
# ERROR: Multiple .bb files are due to be built which each provide virtual/bootloader
# it's just alternative to qi, so it's ok to build both and user will download one of them
PROVIDES = ""

do_configure_prepend() {
  sed -i 's#\(IMAGE = .(IMAGE_DIR)/\)qi-\(.(CPU)-.(BUILD_VERSION)\)#\1qi-ubi-\2#g' ${S}/Makefile
  sed -i 's#\(UDFU_IMAGE = .(IMAGE_DIR)/\)qi-\(.(CPU)-.(BUILD_VERSION).udfu\)#\1qi-ubi-\2#g' ${S}/Makefile
}

SRC_URI_append = "\
  file://rootfstype.ubifs.patch \
"
