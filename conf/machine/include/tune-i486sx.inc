TARGET_ARCH = "i486"
TARGET_CC_ARCH = "-march=i486"
PACKAGE_EXTRA_ARCHS = "486sx"
BASE_PACKAGE_ARCH = "486sx"
FEED_ARCH = "${BASE_PACKAGE_ARCH}"

# gcc doesn't understand softfloat:
# "This target does not support --with-float"

