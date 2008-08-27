# By adding this class to your build all binaries get the special rpath
# "/scratchbox/host_shared/lib/:/scratchbox/tools/lib/"
# Doing so makes libraries and programs runnable inside the Scratchbox
# environment as native binaries (not for the CPU that Scratchbox is
# emulating).

do_configure_prepend () {
  export LD_RUN_PATH="/scratchbox/host_shared/lib:/scratchbox/tools/lib"
}

do_compile_prepend () {
  export LD_RUN_PATH="/scratchbox/host_shared/lib:/scratchbox/tools/lib"
}
