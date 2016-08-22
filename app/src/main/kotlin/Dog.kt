import android.os.Parcel
import android.os.Parcelable

/**
 * Created by artemosipov on 20/08/16.
 */
class Dog (
        var id:Int,
        var title:String
): Parcelable {

    constructor (source: Parcel): this(
            source.readInt(),
            source.readString()

    )



    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeInt(this.id)
        dest?.writeString(this.title)

    }

    companion object {
        @JvmField  val CREATOR: Parcelable.Creator<Dog> = object : Parcelable.Creator<Dog> {
            override fun createFromParcel(source: Parcel): Dog {
                return Dog(source)
            }

            override fun newArray(size: Int): Array<Dog?> {
                return arrayOfNulls(size)
            }
        }


    }
}