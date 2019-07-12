package service;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;
import java.util.Queue;

import render.Camera;

public class DIService {
	public static Canvas canvas;
	public static Graphics g;
	public static BufferStrategy bs;
	
	public static int spriteIndex = 1;
	public static int zoom = 3;
	public static Camera camera;
	public static int moveSpeed = 3;
	
	public static int test = 1;
	public static boolean update = false;
}
