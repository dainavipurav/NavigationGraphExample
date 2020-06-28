package com.example.navigationgraphexample

import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.SparseArray
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.util.isEmpty
import androidx.core.util.isNotEmpty
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.barcode.Barcode
import com.google.android.gms.vision.barcode.BarcodeDetector
import java.util.*
import java.util.jar.Manifest

/**
 * A simple [Fragment] subclass.
 */
class GetFormDataFragment : Fragment(R.layout.fragment_get_form_data) {

    private lateinit var mTextViewShowData: TextView
    private lateinit var name: String
    private lateinit var mobile: String
    private lateinit var location: String

    private lateinit var mSurfaceView: SurfaceView
    private lateinit var mTextViewShowBarcodeData: TextView

    private lateinit var mCameraSource: CameraSource

    private lateinit var mBarcodeDetector: BarcodeDetector

    val REQUEST_IMAGE_CAPTURE = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mTextViewShowData = view.findViewById(R.id.textViewShowData)
        mSurfaceView = view.findViewById(R.id.surfaceView)
        mTextViewShowBarcodeData = view.findViewById(R.id.textViewShowBarcodeData)

        if (arguments != null) {
            val args: GetFormDataFragmentArgs =
                GetFormDataFragmentArgs.fromBundle(arguments as Bundle)
            name = args.name
            mobile = args.mobile
            location = args.location
        } else {
            name = "Dainavi"
            mobile = "9619380028"
            location = "Mumbai"
        }



        mTextViewShowData.text = getString(
            R.string.details,
            name,
            mobile,
            location
        )

        /*mBarcodeDetector = BarcodeDetector.Builder(context).setBarcodeFormats(
            Barcode.QR_CODE
        ).build()

        mCameraSource = CameraSource.Builder(context, mBarcodeDetector)
            .setRequestedPreviewSize(640, 480).build()

        mSurfaceView.holder.addCallback(surfaceCallback)

        mBarcodeDetector.setProcessor(mProcessor)*/

    }

/*
    fun capturePhoto() {
        context?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(it, android.Manifest.permission.CAMERA)
                    == PackageManager.PERMISSION_DENIED ||
                    ContextCompat.checkSelfPermission(
                        it,
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                    )
                    == PackageManager.PERMISSION_DENIED
                ) {
                    val permissions = arrayOf(
                        android.Manifest.permission.CAMERA,
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                    )
                    requestPermissions(permissions, REQUEST_IMAGE_CAPTURE)
                } else {
                    openCamera()
                }
            } else {
                openCamera()
            }
        }
    }

    private fun openCamera(){

        context?.let {

        }
        mBarcodeDetector = BarcodeDetector.Builder(context).build()
        mCameraSource = CameraSource.Builder(context,mBarcodeDetector)
                .build()
        mSurfaceView.holder.addCallback(surfaceCallback)
        mBarcodeDetector.setProcessor(mProcessor)
    }

    private var surfaceCallback = object : SurfaceHolder.Callback {
        override fun surfaceCreated(holder: SurfaceHolder?) {

            if (context?.let {
                    ActivityCompat.checkSelfPermission(
                        it,
                        android.Manifest.permission.CAMERA
                    )
                } != PackageManager.PERMISSION_GRANTED) {
                return
            }
            try {
                mCameraSource.start(holder)
            } catch (exce: Exception) {
                Toast.makeText(context, "Something Went Wrong", Toast.LENGTH_SHORT).show()
            }
        }

        override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {

        }

        override fun surfaceDestroyed(holder: SurfaceHolder?) {
            mCameraSource.stop()
        }


    }

    private var mProcessor = object :Detector.Processor<Barcode>{
        override fun release() {

        }

        override fun receiveDetections(p0: Detector.Detections<Barcode>?) {

            if (p0 != null && p0.detectedItems.size() > 0)
            {
                val qrCode : SparseArray<Barcode> = p0.detectedItems
                val code = qrCode.valueAt(0)

                mTextViewShowBarcodeData.text = code.displayValue
            }


            else{
                mTextViewShowBarcodeData.text = ""
            }
        }
        *//*override fun release() {

        }

        override fun receiveDetections(p0: Detector.Detections<Barcode>()) {
            if (p0 != null && p0){
                var qrCode : SparseArray<Barcode> = p0.detectedItems
                val code = qrCode.valueAt(0)

                mTextViewShowBarcodeData.text = code.displayValue
            }
            else{
                mTextViewShowBarcodeData.text = ""
            }
        }*//*

    }*/
}
