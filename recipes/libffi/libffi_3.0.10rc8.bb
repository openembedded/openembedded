require libffi.inc

# It is a pre-release and should not mess up people's build (consider removal when upgrading to final release)
#
# This recipe worked fine for -native but the build failed when compiled for target! Check if its working for you
# before you chose this version or remove the preference.
DEFAULT_PREFERENCE = "-1"

SRC_URI[md5sum] = "90cebe7dd044835aa777f04194ade5a1"
SRC_URI[sha256sum] = "d629d9b2f34f3daa1432c8011fe49a177d9fc51e7c930d64873a097e33aedb3d"
