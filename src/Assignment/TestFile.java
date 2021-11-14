package Assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.function.Executable;
import java.util.LinkedHashSet;

class TestFile {

	// VERTEX
	@Test
	void testHashCodev0() {
		Vertex v = new Vertex(0,0,0);
		assertEquals(v.hashCode(),0);
	}
	@Test
	void testHashCodev1() {
		Vertex v = new Vertex(3,2,1);
		assertEquals(v.hashCode(),18);
	}
	@Test
	void testVertex() {
		Vertex v = new Vertex(0,1,2);
		assertEquals(v.x,0.0);
		assertEquals(v.y,1.0);
		assertEquals(v.z,2.0);
	}
	@Test // When different
	void testEqualsObjectv() {
		Vertex a = new Vertex(0,0, 0);
		Vertex b = new Vertex(3,1, 2);
		assertEquals(b.equals(a), false);
	}
	@Test  // When different
	void testEqualsObjectv0() {
		Vertex a = new Vertex(1,0, 0);
		Vertex b = new Vertex(0,0, 0);
		assertEquals(b.equals(a), false);
	}
	@Test	// When Same
	void testEqualsObjectv1() {
		Vertex a = new Vertex(0,0, 0);
		Vertex b = new Vertex(0,0, 0);
		assertEquals(b.equals(a), true);
	}
	@Test	// when same object
	void testEqualsObjectv2() {
		Vertex a = new Vertex(0,0, 0);
		Vertex b = a;
		assertEquals(b.equals(a), true);
	}
	@Test	// When Null
	void testEqualsObjectv3() {
		Vertex a = new Vertex(0,0, 0);
		Vertex b = null;
		assertEquals(a.equals(b), false);
	}
	@Test	// When Object is not same
	void testEqualsObjectv4() {
		Vertex a = new Vertex(0,0, 0);
		Integer b = 2 ;
		assertEquals(a.equals(b), false);
	}
	@Test	// When not same
	void testEqualsObjectv5() {
		Vertex a = new Vertex(1.0,1.0, 7.0);
		Vertex b = new Vertex(1,1,7);
		assertEquals(b.equals(a), true);
	}
	@Test
	void testToStringv() {
		Vertex v = new Vertex(0,1,2);
		assertEquals(v.toString(),0.0 + " " + 1.0 + " " + 2.0 + " ");
	}
	@Test
	void testRotateXAxisv() {
		Vertex v = new Vertex(34298,21,342);
		v.rotateXAxis(Math.PI/3);
		assertEquals(v.x,34298.0 );				// 34298.0
		assertEquals(v.y, -285.68069);			//-285.0
		assertEquals(v.z, 189.18653);				//189.0
	}
	@Test
	void testRotateYAxisv() {Vertex v = new Vertex(34298,21,342);
		v.rotateYAxis(Math.PI/3);
		assertEquals(v.x,17445.18069 );
		assertEquals(v.y, 21.0);
		assertEquals(v.z, -29531.9393);
	}
	@Test
	void testRotateZAxisv() {
		Vertex v = new Vertex(34298,21,342);
		v.rotateZAxis(Math.PI/3);
		assertEquals(v.x,17130.81347 );
		assertEquals(v.y, 29713.4393);
		assertEquals(v.z, 342.0);
	}


	// Polygon
	@Test
	void testHashCodep() {
		LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
		Vertex v  = new Vertex(3,2,1);
		Vertex v1 = new Vertex(5,7,1);
		Vertex v2 = new Vertex(0,7,8);
		vertices.add(v);
		vertices.add(v1);
		vertices.add(v2);
		Polygon p = new Polygon(vertices);
		assertEquals(p.hashCode(), 306);
	}
	@Test
	void testPolygon() {
		LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
		Vertex v  = new Vertex(3,2,1);
		Vertex v1 = new Vertex(5,7,1);
		Vertex v2 = new Vertex(0,7,8);
		vertices.add(v);
		vertices.add(v1);
		vertices.add(v2);
		Polygon p = new Polygon(vertices);

		assertTrue(p.vertices.contains(v));
		assertTrue(p.vertices.contains(v1));
		assertTrue(p.vertices.contains(v2));
	}
	@Test // When same
	void testEqualsObjectp() {
		LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
		Vertex v  = new Vertex(3,2,1);
		Vertex v1 = new Vertex(5,7,1);
		Vertex v2 = new Vertex(0,7,8);
		vertices.add(v);
		vertices.add(v1);
		vertices.add(v2);
		Polygon p = new Polygon(vertices);

		vertices = new LinkedHashSet<>();
		Vertex u  = new Vertex(3,2,1);
		Vertex u1 = new Vertex(5,7,1);
		Vertex u2 = new Vertex(0,7,8);
		vertices.add(u);
		vertices.add(u1);
		vertices.add(u2);
		Polygon p1 = new Polygon(vertices);

		assertTrue(p.equals(p1));

	}
	@Test	// When Different
	void testEqualsObjectp1() {
		LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
		Vertex v  = new Vertex(3,2,1);
		Vertex v1 = new Vertex(5,7,1);
		Vertex v2 = new Vertex(0,9,8);
		vertices.add(v);
		vertices.add(v1);
		vertices.add(v2);
		Polygon p = new Polygon(vertices);

		vertices = new LinkedHashSet<>();
		Vertex u  = new Vertex(3,2,1);
		Vertex u1 = new Vertex(5,7,1);
		Vertex u2 = new Vertex(0,7,8);
		vertices.add(u);
		vertices.add(u1);
		vertices.add(u2);
		Polygon p1 = new Polygon(vertices);
		assertEquals(p.equals(p1), false);

	}
	@Test	// When Same
	void testEqualsObjectp2() {
		LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
		Vertex v  = new Vertex(3,2,1);
		Vertex v1 = new Vertex(5,7,1);
		Vertex v2 = new Vertex(0,9,8);
		vertices.add(v);
		vertices.add(v1);
		vertices.add(v2);
		Polygon p = new Polygon(vertices);

		vertices = new LinkedHashSet<>();
		Vertex u  = new Vertex(3,2,1);
		Vertex u1 = new Vertex(5,7,1);
		Vertex u2 = new Vertex(0,9,8);
		vertices.add(u);
		vertices.add(u1);
		vertices.add(u2);
		Polygon p1 = new Polygon(vertices);

		assertTrue(p.equals(p1));

	}
	@Test	// When Same Object
	void testEqualsObjectp3() {
		LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
		Vertex v  = new Vertex(3,2,1);
		Vertex v1 = new Vertex(5,7,1);
		Vertex v2 = new Vertex(0,9,8);
		vertices.add(v);
		vertices.add(v1);
		vertices.add(v2);
		Polygon p = new Polygon(vertices);

		Polygon p1 =p ;

		assertTrue(p.equals(p1));

	}
	@Test	// When null
	void testEqualsObjectp4() {
		LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
		Vertex v  = new Vertex(3,2,1);
		Vertex v1 = new Vertex(5,7,1);
		Vertex v2 = new Vertex(0,9,8);
		vertices.add(v);
		vertices.add(v1);
		vertices.add(v2);
		Polygon p = new Polygon(vertices);


		Polygon p1 =null;

		assertEquals(p.equals(p1), false);


	}
	@Test	// When Object is not same
	void testEqualsObjectp5() {
		LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
		Vertex v  = new Vertex(3,2,1);
		Vertex v1 = new Vertex(5,7,1);
		Vertex v2 = new Vertex(0,9,8);
		vertices.add(v);
		vertices.add(v1);
		vertices.add(v2);
		Polygon p = new Polygon(vertices);
		Integer p1 = 4;
		assertEquals(p.equals(p1), false);

	}
	@Test
	void testRotateXAxisp() {
		LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
		Vertex v  = new Vertex(34298,21,342);
		Vertex v1 = new Vertex(5,7,1);
		Vertex v2 = new Vertex(0,7,8);
		vertices.add(v);
		vertices.add(v1);
		vertices.add(v2);
		Polygon p = new Polygon(vertices);

		p.rotateXAxis(Math.PI/3);

		vertices = new LinkedHashSet<>();
		Vertex u  = new Vertex(34298.0,-285.68069,189.18653);
		Vertex u1 = new Vertex(5.0,2.63397,6.56218);
		Vertex u2 = new Vertex(0.0,-3.4282,10.06218);
		vertices.add(u);
		vertices.add(u1);
		vertices.add(u2);
		Polygon p1 = new Polygon(vertices);


		assertEquals(p1,p);
	}
	@Test
	void testRotateYAxisp() {
		LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
		Vertex v  = new Vertex(34298,21,342);
		Vertex v1 = new Vertex(5,7,1);
		Vertex v2 = new Vertex(0,7,8);
		vertices.add(v);
		vertices.add(v1);
		vertices.add(v2);
		Polygon p = new Polygon(vertices);

		p.rotateYAxis(Math.PI/3);

		vertices = new LinkedHashSet<>();
		Vertex u  = new Vertex(17445.18069 ,21.0,-29531.9393);
		Vertex u1 = new Vertex(3.36603,7.0,-3.83013);
		Vertex u2 = new Vertex(6.9282,7.0,4.0);
		vertices.add(u);
		vertices.add(u1);
		vertices.add(u2);
		Polygon p1 = new Polygon(vertices);


		assertEquals(p1,p);
	}
	@Test
	void testRotateZAxisp() {Vertex v  = new Vertex(34298,21,342);
		LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
		Vertex v1 = new Vertex(5,7,1);
		Vertex v2 = new Vertex(0,7,8);
		vertices.add(v);
		vertices.add(v1);
		vertices.add(v2);
		Polygon p = new Polygon(vertices);

		p.rotateZAxis(Math.PI/3);

		vertices = new LinkedHashSet<>();
		Vertex u  = new Vertex(17130.81347 ,29713.4393,342.0);
		Vertex u1 = new Vertex(-3.56218,7.83013,1.0);
		Vertex u2 = new Vertex(-6.06218,3.5,8.0);
		vertices.add(u);
		vertices.add(u1);
		vertices.add(u2);
		Polygon p1 = new Polygon(vertices);

		assertEquals(p1,p);
	}

	//Mesh
	@Test
	void testHashCodem() {
			LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
			Vertex v  = new Vertex(3,2,1);
			Vertex v1 = new Vertex(5,7,1);
			Vertex v2 = new Vertex(0,7,8);
			vertices.add(v);
			vertices.add(v1);
			vertices.add(v2);
			Polygon p = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex u  = new Vertex(3,2,1);
			Vertex u1 = new Vertex(5,7,1);
			Vertex u2 = new Vertex(0,7,8);
			vertices.add(u);
			vertices.add(u1);
			vertices.add(u2);
			Polygon p1 = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex o  = new Vertex(3,2,1);
			Vertex o1 = new Vertex(5,7,1);
			Vertex o2 = new Vertex(0,7,8);
			vertices.add(o);
			vertices.add(o1);
			vertices.add(o2);
			Polygon p2 = new Polygon(vertices);
			HashSet<Polygon> polygons = new HashSet<>();
			polygons.add(p);
			polygons.add(p1);
			polygons.add(p2);
			Mesh m = new Mesh();
			m.polygons = polygons;
			assertEquals(m.hashCode(), 918);


		}
	@Test	// Same
	void testEqualsObjectm() {
			LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
			Vertex v  = new Vertex(3,2,1);
			Vertex v1 = new Vertex(5,7,1);
			Vertex v2 = new Vertex(0,7,8);
			vertices.add(v);
			vertices.add(v1);
			vertices.add(v2);
			Polygon p = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex u  = new Vertex(3,2,1);
			Vertex u1 = new Vertex(5,7,1);
			Vertex u2 = new Vertex(0,7,8);
			vertices.add(u);
			vertices.add(u1);
			vertices.add(u2);
			Polygon p1 = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex o  = new Vertex(3,2,1);
			Vertex o1 = new Vertex(5,7,1);
			Vertex o2 = new Vertex(0,7,8);
			vertices.add(o);
			vertices.add(o1);
			vertices.add(o2);
			Polygon p2 = new Polygon(vertices);
			HashSet<Polygon> polygons = new HashSet<>();
			polygons.add(p);
			polygons.add(p1);
			polygons.add(p2);
			Mesh m = new Mesh();
			m.polygons = polygons;





			vertices = new LinkedHashSet<>();
			v  = new Vertex(3,2,1);
			v1 = new Vertex(5,7,1);
			v2 = new Vertex(0,7,8);
			vertices.add(v);
			vertices.add(v1);
			vertices.add(v2);
			p = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			u  = new Vertex(3,2,1);
			u1 = new Vertex(5,7,1);
			u2 = new Vertex(0,7,8);
			vertices.add(u);
			vertices.add(u1);
			vertices.add(u2);
			p1 = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			o  = new Vertex(3,2,1);
			o1 = new Vertex(5,7,1);
			o2 = new Vertex(0,7,8);
			vertices.add(o);
			vertices.add(o1);
			vertices.add(o2);
			p2 = new Polygon(vertices);

			polygons = new HashSet<>();
			polygons.add(p);
			polygons.add(p1);
			polygons.add(p2);
			Mesh m1 = new Mesh();
			m1.polygons = polygons;

			assertTrue(m.equals(m1));
		}
	@Test	// Different
	void testEqualsObjectm1() {
			LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
			Vertex v  = new Vertex(3,2,1);
			Vertex v1 = new Vertex(5,7,1);
			Vertex v2 = new Vertex(0,7,8);
			vertices.add(v);
			vertices.add(v1);
			vertices.add(v2);
			Polygon p = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex u  = new Vertex(3,2,1);
			Vertex u1 = new Vertex(5,7,1);
			Vertex u2 = new Vertex(0,7,8);
			vertices.add(u);
			vertices.add(u1);
			vertices.add(u2);
			Polygon p1 = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex o  = new Vertex(3,2,1);
			Vertex o1 = new Vertex(5,7,1);
			Vertex o2 = new Vertex(0,7,8);
			vertices.add(o);
			vertices.add(o1);
			vertices.add(o2);
			Polygon p2 = new Polygon(vertices);
			HashSet<Polygon> polygons = new HashSet<>();
			polygons.add(p);
			polygons.add(p1);
			polygons.add(p2);
			Mesh m = new Mesh();
			m.polygons = polygons;



			vertices = new LinkedHashSet<>();
			v  = new Vertex(3,2,1);
			v1 = new Vertex(6,7,1);
			v2 = new Vertex(0,7,8);
			vertices.add(v);
			vertices.add(v1);
			vertices.add(v2);
			p = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			u  = new Vertex(3,2,1);
			u1 = new Vertex(5,7,1);
			u2 = new Vertex(0,7,8);
			vertices.add(u);
			vertices.add(u1);
			vertices.add(u2);
			p1 = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			o  = new Vertex(3,2,1);
			o1 = new Vertex(5,7,1);
			o2 = new Vertex(0,7,8);
			vertices.add(o);
			vertices.add(o1);
			vertices.add(o2);
			p2 = new Polygon(vertices);

			polygons = new HashSet<>();
			polygons.add(p);
			polygons.add(p1);
			polygons.add(p2);
			Mesh m1 = new Mesh();
			m1.polygons = polygons;

			assertEquals(m1.equals(m), false);
		}
	@Test	// Different
	void testEqualsObjectm2() {
			LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
			Vertex v  = new Vertex(35,1,0);
			Vertex v1 = new Vertex(54,9,4);
			Vertex v2 = new Vertex(0,8,5);
			vertices.add(v);
			vertices.add(v1);
			vertices.add(v2);
			Polygon p = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex u  = new Vertex(3,2,1);
			Vertex u1 = new Vertex(5,7,1);
			Vertex u2 = new Vertex(0,7,8);
			vertices.add(u);
			vertices.add(u1);
			vertices.add(u2);
			Polygon p1 = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex o  = new Vertex(3,2,1);
			Vertex o1 = new Vertex(5,7,1);
			Vertex o2 = new Vertex(0,7,8);
			vertices.add(o);
			vertices.add(o1);
			vertices.add(o2);
			Polygon p2 = new Polygon(vertices);
			HashSet<Polygon> polygons = new HashSet<>();
			polygons.add(p);
			polygons.add(p1);
			polygons.add(p2);
			Mesh m = new Mesh();
			m.polygons = polygons;

			vertices = new LinkedHashSet<>();
			v  = new Vertex(3,2,1);
			v1 = new Vertex(6,7,1);
			v2 = new Vertex(0,7,8);
			vertices.add(v);
			vertices.add(v1);
			vertices.add(v2);
			p = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			u  = new Vertex(3,2,1);
			u1 = new Vertex(5,7,1);
			u2 = new Vertex(0,7,8);
			vertices.add(u);
			vertices.add(u1);
			vertices.add(u2);
			p1 = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			o  = new Vertex(3,2,1);
			o1 = new Vertex(5,7,1);
			o2 = new Vertex(0,7,8);
			vertices.add(o);
			vertices.add(o1);
			vertices.add(o2);
			p2 = new Polygon(vertices);

			polygons = new HashSet<>();
			polygons.add(p);
			polygons.add(p1);
			polygons.add(p2);
			Mesh m1 = new Mesh();
			m1.polygons = polygons;

			assertEquals(m.equals(m1), false);
		}
	@Test	// Same
	void testEqualsObjectm3() {
			LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
			Vertex v  = new Vertex(35,1,0);
			Vertex v1 = new Vertex(54,9,4);
			Vertex v2 = new Vertex(0,8,5);
			vertices.add(v);
			vertices.add(v1);
			vertices.add(v2);
			Polygon p = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex u  = new Vertex(3,2,1);
			Vertex u1 = new Vertex(5,7,1);
			Vertex u2 = new Vertex(0,7,8);
			vertices.add(u);
			vertices.add(u1);
			vertices.add(u2);
			Polygon p1 = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex o  = new Vertex(3,2,1);
			Vertex o1 = new Vertex(5,7,1);
			Vertex o2 = new Vertex(0,7,8);
			vertices.add(o);
			vertices.add(o1);
			vertices.add(o2);
			Polygon p2 = new Polygon(vertices);
			HashSet<Polygon> polygons = new HashSet<>();
			polygons.add(p);
			polygons.add(p1);
			polygons.add(p2);
			Mesh m = new Mesh();
			m.polygons = polygons;

			Mesh m1 = new Mesh();
			m1.polygons = polygons;

			assertEquals(m.equals(m1), true);
		}
	@Test	// Same Object
	void testEqualsObjectm4() {
			LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
			Vertex v  = new Vertex(35,1,0);
			Vertex v1 = new Vertex(54,9,4);
			Vertex v2 = new Vertex(0,8,5);
			vertices.add(v);
			vertices.add(v1);
			vertices.add(v2);
			Polygon p = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex u  = new Vertex(3,2,1);
			Vertex u1 = new Vertex(5,7,1);
			Vertex u2 = new Vertex(0,7,8);
			vertices.add(u);
			vertices.add(u1);
			vertices.add(u2);
			Polygon p1 = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex o  = new Vertex(3,2,1);
			Vertex o1 = new Vertex(5,7,1);
			Vertex o2 = new Vertex(0,7,8);
			vertices.add(o);
			vertices.add(o1);
			vertices.add(o2);
			Polygon p2 = new Polygon(vertices);
			HashSet<Polygon> polygons = new HashSet<>();
			polygons.add(p);
			polygons.add(p1);
			polygons.add(p2);
			Mesh m = new Mesh();
			m.polygons = polygons;

			Mesh m1 = m;

			assertEquals(m.equals(m1), true);
		}
	@Test	// Null
	void testEqualsObjectm5() {
			LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
			Vertex v  = new Vertex(35,1,0);
			Vertex v1 = new Vertex(54,9,4);
			Vertex v2 = new Vertex(0,8,5);
			vertices.add(v);
			vertices.add(v1);
			vertices.add(v2);
			Polygon p = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex u  = new Vertex(3,2,1);
			Vertex u1 = new Vertex(5,7,1);
			Vertex u2 = new Vertex(0,7,8);
			vertices.add(u);
			vertices.add(u1);
			vertices.add(u2);
			Polygon p1 = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex o  = new Vertex(3,2,1);
			Vertex o1 = new Vertex(5,7,1);
			Vertex o2 = new Vertex(0,7,8);
			vertices.add(o);
			vertices.add(o1);
			vertices.add(o2);
			Polygon p2 = new Polygon(vertices);
			HashSet<Polygon> polygons = new HashSet<>();
			polygons.add(p);
			polygons.add(p1);
			polygons.add(p2);
			Mesh m = new Mesh();
			m.polygons = polygons;

			Mesh m1 = null;

			assertEquals(m.equals(m1), false);
		}
	@Test  // Object not same
	void testEqualsObjectm6() {
			LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
			Vertex v  = new Vertex(35,1,0);
			Vertex v1 = new Vertex(54,9,4);
			Vertex v2 = new Vertex(0,8,5);
			vertices.add(v);
			vertices.add(v1);
			vertices.add(v2);
			Polygon p = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex u  = new Vertex(3,2,1);
			Vertex u1 = new Vertex(5,7,1);
			Vertex u2 = new Vertex(0,7,8);
			vertices.add(u);
			vertices.add(u1);
			vertices.add(u2);
			Polygon p1 = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex o  = new Vertex(3,2,1);
			Vertex o1 = new Vertex(5,7,1);
			Vertex o2 = new Vertex(0,7,8);
			vertices.add(o);
			vertices.add(o1);
			vertices.add(o2);
			Polygon p2 = new Polygon(vertices);
			HashSet<Polygon> polygons = new HashSet<>();
			polygons.add(p);
			polygons.add(p1);
			polygons.add(p2);
			Mesh m = new Mesh();
			m.polygons = polygons;

			Integer m1 = 3;

			assertEquals(m.equals(m1), false);
		}
	@Test
	void testRotateXAxism() {
			LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
			Vertex v  = new Vertex(34298,21,342);
			Vertex v1 = new Vertex(5,7,1);
			Vertex v2 = new Vertex(0,7,8);
			vertices.add(v);
			vertices.add(v1);
			vertices.add(v2);
			Polygon p = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex u  = new Vertex(34298,21,342);
			Vertex u1 = new Vertex(5,7,1);
			Vertex u2 = new Vertex(0,7,8);
			vertices.add(u);
			vertices.add(u1);
			vertices.add(u2);
			Polygon p1 = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex o  = new Vertex(34298,21,342);
			Vertex o1 = new Vertex(5,7,1);
			Vertex o2 = new Vertex(0,7,8);
			vertices.add(o);
			vertices.add(o1);
			vertices.add(o2);
			Polygon p2 = new Polygon(vertices);
			HashSet<Polygon> polygons = new HashSet<>();
			polygons.add(p);
			polygons.add(p1);
			polygons.add(p2);
			Mesh m = new Mesh();
			m.polygons = polygons;


			m.rotateXAxis(Math.PI/3);


			vertices = new LinkedHashSet<>();
			v  = new Vertex(34298.0,-285.68069,189.18653);
			v1 = new Vertex(5.0,2.63397,6.56218);
			v2 = new Vertex(0.0,-3.4282,10.06218);
			vertices.add(v);
			vertices.add(v1);
			vertices.add(v2);
			p = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			u  = new Vertex(34298.0,-285.68069,189.18653);
			u1 = new Vertex(5.0,2.63397,6.56218);
			u2 = new Vertex(0.0,-3.4282,10.06218);
			vertices.add(u);
			vertices.add(u1);
			vertices.add(u2);
			p1 = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			o  = new Vertex(34298.0,-285.68069,189.18653);
			o1 = new Vertex(5.0,2.63397,6.56218);
			o2 = new Vertex(0.0,-3.4282,10.06218);
			vertices.add(o);
			vertices.add(o1);
			vertices.add(o2);
			p2 = new Polygon(vertices);

			polygons = new HashSet<>();
			polygons.add(p);
			polygons.add(p1);
			polygons.add(p2);
			Mesh m1 = new Mesh();
			m1.polygons = polygons;

			assertEquals(m1,m);
		}
	@Test
	void testRotateYAxis() {
			LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
			Vertex v  = new Vertex(34298,21,342);
			Vertex v1 = new Vertex(5,7,1);
			Vertex v2 = new Vertex(0,7,8);
			vertices.add(v);
			vertices.add(v1);
			vertices.add(v2);
			Polygon p = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex u  = new Vertex(34298,21,342);
			Vertex u1 = new Vertex(5,7,1);
			Vertex u2 = new Vertex(0,7,8);
			vertices.add(u);
			vertices.add(u1);
			vertices.add(u2);
			Polygon p1 = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex o  = new Vertex(34298,21,342);
			Vertex o1 = new Vertex(5,7,1);
			Vertex o2 = new Vertex(0,7,8);
			vertices.add(o);
			vertices.add(o1);
			vertices.add(o2);
			Polygon p2 = new Polygon(vertices);
			HashSet<Polygon> polygons = new HashSet<>();
			polygons.add(p);
			polygons.add(p1);
			polygons.add(p2);
			Mesh m = new Mesh();
			m.polygons = polygons;


			m.rotateYAxis(Math.PI/3);


			vertices = new LinkedHashSet<>();
			v  = new Vertex(17445.18069 ,21.0,-29531.9393);
			v1 = new Vertex(3.36603,7.0,-3.83013);
			v2 = new Vertex(6.9282,7.0,4.0);
			vertices.add(v);
			vertices.add(v1);
			vertices.add(v2);
			p = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			u  = new Vertex(17445.18069 ,21.0,-29531.9393);
			u1 = new Vertex(3.36603,7.0,-3.83013);
			u2 = new Vertex(6.9282,7.0,4.0);
			vertices.add(u);
			vertices.add(u1);
			vertices.add(u2);
			p1 = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			o  = new Vertex(17445.18069 ,21.0,-29531.9393);
			o1 = new Vertex(3.36603,7.0,-3.83013);
			o2 = new Vertex(6.9282,7.0,4.0);
			vertices.add(o);
			vertices.add(o1);
			vertices.add(o2);
			p2 = new Polygon(vertices);

			polygons = new HashSet<>();
			polygons.add(p);
			polygons.add(p1);
			polygons.add(p2);
			Mesh m1 = new Mesh();
			m1.polygons = polygons;

			assertEquals(m1,m);
		}
	@Test
	void testRotateZAxis() {
			LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
			Vertex v  = new Vertex(34298,21,342);
			Vertex v1 = new Vertex(5,7,1);
			Vertex v2 = new Vertex(0,7,8);
			vertices.add(v);
			vertices.add(v1);
			vertices.add(v2);
			Polygon p = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex u  = new Vertex(34298,21,342);
			Vertex u1 = new Vertex(5,7,1);
			Vertex u2 = new Vertex(0,7,8);
			vertices.add(u);
			vertices.add(u1);
			vertices.add(u2);
			Polygon p1 = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex o  = new Vertex(34298,21,342);
			Vertex o1 = new Vertex(5,7,1);
			Vertex o2 = new Vertex(0,7,8);
			vertices.add(o);
			vertices.add(o1);
			vertices.add(o2);
			Polygon p2 = new Polygon(vertices);
			HashSet<Polygon> polygons = new HashSet<>();
			polygons.add(p);
			polygons.add(p1);
			polygons.add(p2);
			Mesh m = new Mesh();
			m.polygons = polygons;


			m.rotateZAxis(Math.PI/3);


			vertices = new LinkedHashSet<>();
			v  = new Vertex(17130.81347 ,29713.4393,342.0);
			v1 = new Vertex(-3.56218,7.83013,1.0);
			v2 = new Vertex(-6.06218,3.5,8.0);
			vertices.add(v);
			vertices.add(v1);
			vertices.add(v2);
			p = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			u  = new Vertex(17130.81347 ,29713.4393,342.0);
			u1 = new Vertex(-3.56218,7.83013,1.0);
			u2 = new Vertex(-6.06218,3.5,8.0);
			vertices.add(u);
			vertices.add(u1);
			vertices.add(u2);
			p1 = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			o  = new Vertex(17130.81347 ,29713.4393,342.0);
			o1 = new Vertex(-3.56218,7.83013,1.0);
			o2 = new Vertex(-6.06218,3.5,8.0);
			vertices.add(o);
			vertices.add(o1);
			vertices.add(o2);
			p2 = new Polygon(vertices);

			polygons = new HashSet<>();
			polygons.add(p);
			polygons.add(p1);
			polygons.add(p2);
			Mesh m1 = new Mesh();
			m1.polygons = polygons;

			assertEquals(m1,m);
		}
	@Test
	void testSetReader() {
			Mesh mesh = new Mesh();
			OBJMeshReader c = new OBJMeshReader();
			mesh.setReader(c);
			assertEquals(mesh.reader,c);
		}
	@Test
	void testSetWriter() {
			Mesh mesh = new Mesh();
			OBJMeshWriter c = new OBJMeshWriter();
			mesh.setWriter(c);
			assertEquals(mesh.writer,c);
		}
	@Test
	void testReadFromFile() throws Exception {
			Mesh mesh = new Mesh();
			mesh.setReader(new OBJMeshReader());
			mesh.readFromFile(new File("C:\\Users\\yasha\\OneDrive - University of Toronto\\Desktop\\Computer science\\Java\\Assignment\\abc.obj"));
			LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
			Vertex v  = new Vertex(4.14607,-1.39563,2.18563);
			Vertex v1 = new Vertex(3.76402,-1.69947,2.30437);
			Vertex v2 = new Vertex(3.92762,-1.37844,2.18556);
			vertices.add(v);
			vertices.add(v1);
			vertices.add(v2);
			Polygon p = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex u  = new Vertex(4.14607,-1.39563,2.18563);
			Vertex u1 = new Vertex(3.92762,-1.37844,2.18556);
			Vertex u2 = new Vertex(3.53446,-1.50341,2.30429);
			vertices.add(u);
			vertices.add(u1);
			vertices.add(u2);
			Polygon p1 = new Polygon(vertices);

			vertices = new LinkedHashSet<>();
			Vertex o  = new Vertex(4.14607,-1.39563,2.18563);
			Vertex o1 = new Vertex(3.53446,-1.50341,2.30429);
			Vertex o2 = new Vertex(3.82598,-1.29163,2.18552);
			vertices.add(o);
			vertices.add(o1);
			vertices.add(o2);
			Polygon p2 = new Polygon(vertices);
			HashSet<Polygon> polygons = new HashSet<>();
			polygons.add(p);
			polygons.add(p1);
			polygons.add(p2);
			Mesh m = new Mesh();
			m.polygons = polygons;
			assertEquals(m,mesh);}
	// TODO
	@Test
	void testWriteToFile() {
			Mesh mesh = new Mesh();
			mesh.setWriter(new OBJMeshWriter());
		}

	//ObjMeshReader
	@Test //Exception
	void testRead() throws Exception {
	try{
		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		mesh.readFromFile(new File("C:\\Users\\yasha\\OneDrive - University of Toronto\\Desktop\\Computer science\\Java\\Assignment\\c.obj"));
	}catch (IOException e){
		assertTrue(true);
	}

	}
	@Test
	void testRead1() throws Exception {
		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		mesh.readFromFile(new File("C:\\Users\\yasha\\OneDrive - University of Toronto\\Desktop\\Computer science\\Java\\Assignment\\abc.obj"));
		LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
		Vertex v  = new Vertex(4.14607,-1.39563,2.18563);
		Vertex v1 = new Vertex(3.76402,-1.69947,2.30437);
		Vertex v2 = new Vertex(3.92762,-1.37844,2.18556);
		vertices.add(v);
		vertices.add(v1);
		vertices.add(v2);
		Polygon p = new Polygon(vertices);

		vertices = new LinkedHashSet<>();
		Vertex u  = new Vertex(4.14607,-1.39563,2.18563);
		Vertex u1 = new Vertex(3.92762,-1.37844,2.18556);
		Vertex u2 = new Vertex(3.53446,-1.50341,2.30429);
		vertices.add(u);
		vertices.add(u1);
		vertices.add(u2);
		Polygon p1 = new Polygon(vertices);

		vertices = new LinkedHashSet<>();
		Vertex o  = new Vertex(4.14607,-1.39563,2.18563);
		Vertex o1 = new Vertex(3.53446,-1.50341,2.30429);
		Vertex o2 = new Vertex(3.82598,-1.29163,2.18552);
		vertices.add(o);
		vertices.add(o1);
		vertices.add(o2);
		Polygon p2 = new Polygon(vertices);
		HashSet<Polygon> polygons = new HashSet<>();
		polygons.add(p);
		polygons.add(p1);
		polygons.add(p2);
		Mesh m = new Mesh();
		m.polygons = polygons;
		assertEquals(m,mesh);
	}

	//PlyMeshReader
	@Test
	void testRead2() throws Exception {
		Mesh mesh = new Mesh();
		mesh.setReader(new PLYMeshReader());
		mesh.readFromFile(new File("C:\\Users\\yasha\\OneDrive - University of Toronto\\Desktop\\Computer science\\Java\\Assignment\\abc.ply"));
		LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
		Vertex v  = new Vertex(4.14607,-1.39563,2.18563);
		Vertex v1 = new Vertex(3.76402,-1.69947,2.30437);
		Vertex v2 = new Vertex(3.92762,-1.37844,2.18556);
		vertices.add(v);
		vertices.add(v1);
		vertices.add(v2);
		Polygon p = new Polygon(vertices);

		vertices = new LinkedHashSet<>();
		Vertex u  = new Vertex(4.14607,-1.39563,2.18563);
		Vertex u1 = new Vertex(3.92762,-1.37844,2.18556);
		Vertex u2 = new Vertex(3.53446,-1.50341,2.30429);
		vertices.add(u);
		vertices.add(u1);
		vertices.add(u2);
		Polygon p1 = new Polygon(vertices);

		vertices = new LinkedHashSet<>();
		Vertex o  = new Vertex(4.14607,-1.39563,2.18563);
		Vertex o1 = new Vertex(3.53446,-1.50341,2.30429);
		Vertex o2 = new Vertex(3.82598,-1.29163,2.18552);
		vertices.add(o);
		vertices.add(o1);
		vertices.add(o2);
		Polygon p2 = new Polygon(vertices);
		HashSet<Polygon> polygons = new HashSet<>();
		polygons.add(p);
		polygons.add(p1);
		polygons.add(p2);
		Mesh m = new Mesh();
		m.polygons = polygons;
		assertEquals(mesh,m);
	}
	@Test //Exception
	void testRead3() throws Exception {

		try {
			Mesh mesh = new Mesh();
			mesh.setReader(new PLYMeshReader());
			mesh.readFromFile(new File("5C::\\\\\\\\Users\\\\\\\\yasha\\\\\\\\OneDrive - University of Toronto\\\\\\\\Desktop\\\\\\\\"));
			assertTrue(false);
		}catch (IOException e){
			assertTrue(true);
		}

	}

	//ObjMeshWriter
	@Test
	void testWrite() throws Exception {
		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		mesh.readFromFile(new File("C:\\Users\\yasha\\OneDrive - University of Toronto\\Desktop\\Computer science\\Java\\Assignment\\abc.obj"));

		mesh.rotateXAxis(Math.PI/3);

		mesh.setWriter(new OBJMeshWriter());
		mesh.writeToFile(new File("C:\\Users\\yasha\\OneDrive - University of Toronto\\Desktop\\Computer science\\Java\\Assignment\\abc_rotated.obj"));



		Mesh mesh1 = new Mesh();
		mesh1.setReader(new OBJMeshReader());
		mesh1.readFromFile(new File("C:\\Users\\yasha\\OneDrive - University of Toronto\\Desktop\\Computer science\\Java\\Assignment\\abc_rotated.obj"));

		LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
		Vertex v  = new Vertex(4.14607,-2.59063,-0.11584);
		Vertex v1 = new Vertex(3.76402,-2.84538,-0.3196);
		Vertex v2 = new Vertex(3.92762,-2.58197, -0.10098);
		vertices.add(v);
		vertices.add(v1);
		vertices.add(v2);
		Polygon p = new Polygon(vertices);

		vertices = new LinkedHashSet<>();
		Vertex u  = new Vertex(4.14607,-2.59063,-0.11584);
		Vertex u1 = new Vertex(3.92762,-2.58197, -0.10098);
		Vertex u2 = new Vertex(3.53446,-2.74728, -0.14985);
		vertices.add(u);
		vertices.add(u1);
		vertices.add(u2);
		Polygon p1 = new Polygon(vertices);

		vertices = new LinkedHashSet<>();
		Vertex o  = new Vertex(4.14607,-2.59063,-0.11584);
		Vertex o1 = new Vertex(3.53446,-2.74728, -0.14985);
		Vertex o2 = new Vertex(3.82598,-2.53853, -0.02582);
		vertices.add(o);
		vertices.add(o1);
		vertices.add(o2);
		Polygon p2 = new Polygon(vertices);
		HashSet<Polygon> polygons = new HashSet<>();
		polygons.add(p);
		polygons.add(p1);
		polygons.add(p2);
		Mesh m = new Mesh();
		m.polygons = polygons;
		assertEquals(mesh1,m);

	}
	@Test
	void testWrite1() throws Exception {
			try {
				Mesh mesh = new Mesh();
				mesh.setReader(new OBJMeshReader());
				mesh.readFromFile(new File("C:\\Users\\yasha\\OneDrive - University of Toronto\\Desktop\\Computer science\\Java\\Assignment\\abc.obj"));

				mesh.rotateXAxis(Math.PI / 3);

				mesh.setWriter(new OBJMeshWriter());
				mesh.writeToFile(new File("")); // Throws exception
				assertTrue(false);
			}catch (IOException e){
				assertTrue(true);
			}


	}

	//PlyMeshWriter
	@Test
	void testWrite2() throws Exception {
		Mesh mesh = new Mesh();
		mesh.setReader(new PLYMeshReader());
		mesh.readFromFile(new File("C:\\Users\\yasha\\OneDrive - University of Toronto\\Desktop\\Computer science\\Java\\Assignment\\abc.ply"));
		mesh.rotateXAxis(Math.PI/3);

		mesh.setWriter(new PLYMeshWriter());
		mesh.writeToFile(new File("C:\\Users\\yasha\\OneDrive - University of Toronto\\Desktop\\Computer science\\Java\\Assignment\\abc_rotated.ply"));



		Mesh mesh1 = new Mesh();
		mesh1.setReader(new PLYMeshReader());
		mesh1.readFromFile(new File("C:\\Users\\yasha\\OneDrive - University of Toronto\\Desktop\\Computer science\\Java\\Assignment\\abc_rotated.ply"));

		LinkedHashSet<Vertex> vertices = new LinkedHashSet<>();
		Vertex v  = new Vertex(4.14607,-2.59063,-0.11584);
		Vertex v1 = new Vertex(3.76402,-2.84538,-0.3196);
		Vertex v2 = new Vertex(3.92762,-2.58197, -0.10098);
		vertices.add(v);
		vertices.add(v1);
		vertices.add(v2);
		Polygon p = new Polygon(vertices);

		vertices = new LinkedHashSet<>();
		Vertex u  = new Vertex(4.14607,-2.59063,-0.11584);
		Vertex u1 = new Vertex(3.92762,-2.58197, -0.10098);
		Vertex u2 = new Vertex(3.53446,-2.74728, -0.14985);
		vertices.add(u);
		vertices.add(u1);
		vertices.add(u2);
		Polygon p1 = new Polygon(vertices);

		vertices = new LinkedHashSet<>();
		Vertex o  = new Vertex(4.14607,-2.59063,-0.11584);
		Vertex o1 = new Vertex(3.53446,-2.74728, -0.14985);
		Vertex o2 = new Vertex(3.82598,-2.53853, -0.02582);
		vertices.add(o);
		vertices.add(o1);
		vertices.add(o2);
		Polygon p2 = new Polygon(vertices);
		HashSet<Polygon> polygons = new HashSet<>();
		polygons.add(p);
		polygons.add(p1);
		polygons.add(p2);
		Mesh m = new Mesh();
		m.polygons = polygons;
		assertEquals(mesh1,m);

	}
	@Test
	void testWrite3() throws Exception {

				try {
					Mesh mesh = new Mesh();
					mesh.setReader(new PLYMeshReader());
					mesh.readFromFile(new File("C:\\Users\\yasha\\OneDrive - University of Toronto\\Desktop\\Computer science\\Java\\Assignment\\abc.ply"));

					mesh.rotateXAxis(Math.PI / 3);

					mesh.setWriter(new PLYMeshWriter());
					mesh.writeToFile(new File("")); // Throws exception
					assertTrue(false);
				}catch (IOException e){
					assertTrue(true);
				}
			}

	

}
