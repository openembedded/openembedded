# Add glibc overrides to the overrides for eglibc.
OVERRIDES .= ":libc-glibc"

# The things eglibc can provide.  We default to wanting eglibc to provide them.
PREFERRED_PROVIDER_virtual/libiconv ?= "eglibc"
PREFERRED_PROVIDER_virtual/libintl ?= "eglibc"
PREFERRED_PROVIDER_virtual/libc = "eglibc"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}libc-initial = "eglibc-initial"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}libc-for-gcc = "eglibc"
