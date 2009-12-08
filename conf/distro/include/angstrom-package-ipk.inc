INHERIT += "package_ipk"

PREFERRED_PROVIDER_virtual/update-alternatives-native ?= "opkg-native"
PREFERRED_PROVIDER_virtual/update-alternatives ?= ${PREFERRED_PROVIDER_opkg}
