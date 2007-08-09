require gdb.inc

PR = "r2"

#only append it for glib, not for uclibc
RRECOMMENDS_gdb_append_linux = " glibc-thread-db "
RRECOMMENDS_gdb_append_linux-gnueabi = " glibc-thread-db "
