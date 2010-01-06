require qi_git.bb

do_configure_prepend() {
  sed -i 's#\(IMAGE = .(IMAGE_DIR)/\)qi-\(.(CPU)-.(BUILD_VERSION)\)#\1qi-ubi-\2#g' ${S}/Makefile
  sed -i 's#\(UDFU_IMAGE = .(IMAGE_DIR)/\)qi-\(.(CPU)-.(BUILD_VERSION).udfu\)#\1qi-ubi-\2#g' ${S}/Makefile
}

SRC_URI_append = "\
  file://0002-gta02-add-kernel-params-to-boot-from-ubifs-ubi0-om-g.patch;patch=1 \
"
