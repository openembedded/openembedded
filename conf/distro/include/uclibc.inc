# Add uclibc overrides to the overrides.
OVERRIDES .= ":libc-uclibc"

# The things uclibc can provide.  We default to wanting uclibc to provide them.
PREFERRED_PROVIDER_virtual/libiconv ?= "libiconv"
PREFERRED_PROVIDER_virtual/libintl ?= "gettext"
#fix some iconv issues, needs to be adjusted when doing uclibc builds
PREFERRED_PROVIDER_virtual/libintl_avr32 = "proxy-libintl"
PREFERRED_PROVIDER_virtual/libc = "uclibc"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}libc-initial = "uclibc-initial"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}libc-for-gcc = "uclibc"
