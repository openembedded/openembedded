#include <gtk/gtk.h>
#include <gdk-pixbuf/gdk-pixbuf.h>

static gdouble total_seconds = 0.0;


int
main (int argc, char **argv)
{
        GTimer *timer;

        gtk_init (&argc, &argv);


	GdkPixbuf *pixbuf, *ret;
	pixbuf = gdk_pixbuf_new_from_file("/usr/share/pixop-test/gtk-logo-rgb.gif", NULL);

	timer = g_timer_new ();
	g_timer_start (timer);

	int i;

	for (i = 1; i <= 100 ; i++) {
		ret = gdk_pixbuf_scale_simple (pixbuf, 800, 600, GDK_INTERP_BILINEAR);
		ret = gdk_pixbuf_scale_simple (pixbuf, 300, 400, GDK_INTERP_BILINEAR);
	}
	g_timer_stop (timer);

	total_seconds += g_timer_elapsed (timer, NULL);
        
        gtk_main ();

        g_print ("time spent scaling (in seconds): %lf\n",  total_seconds );

        return 0;
}
