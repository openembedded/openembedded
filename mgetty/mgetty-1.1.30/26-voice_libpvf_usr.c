--- mgetty-1.1.27.orig/voice/libpvf/usr.c
+++ mgetty-1.1.27/voice/libpvf/usr.c
@@ -103,9 +103,13 @@
          }
        }
        gsm_encode(r, s, d);
+#if defined(old_USR_GSM_with_head_and_tail_bytes)
        fwrite((char *)gsm_head, 2, 1, fd_out);
+#endif
        fwrite((char *)d, sizeof(d), 1, fd_out);
+#if defined(old_USR_GSM_with_head_and_tail_bytes)
        fwrite((char *)gsm_tail, 3, 1, fd_out);
+#endif
      }
      gsm_destroy(r);
      return(OK);
