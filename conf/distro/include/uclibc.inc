# Add uclibc overrides to the overrides.
OVERRIDES =. "libc-uclibc:"

# The things uclibc can provide.  We default to wanting uclibc to provide them.
PREFERRED_PROVIDER_virtual/libiconv ?= "libiconv"
PREFERRED_PROVIDER_virtual/libintl ?= "proxy-libintl"
#fix some iconv issues, needs to be adjusted when doing uclibc builds
PREFERRED_PROVIDER_virtual/libintl_avr32 = "proxy-libintl"
PREFERRED_PROVIDER_virtual/libc = "uclibc"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}libc-initial = "uclibc-initial"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}libc-for-gcc = "uclibc"

# libc settings
DISTRO_FEATURES += "${@['', ' nls'][bb.data.getVar('ENABLE_BINARY_LOCALE_GENERATION', d, 1) == '1']}"
MACHINE_FEATURES += "${@['', ' bx'][bb.data.getVar('ARM_INSTRUCTION_SET', d, 1) == 'thumb']}"
# FIXME: We enable IPv4 per default to avoid alot of breakage.
# FIXME: Figure out an acceptable way to negotiate either
# FIXME: desired features or hard requirements, either top-down or bottom-up.
DISTRO_FEATURES += " ipv4"
